package DataFlow;

import java.util.LinkedList;

public class DataFlowMain {

	public void dummyFunction(String[] titleArray){
		
		
		
	}
	private DataSink finalTitleList;
	private static DataSource dataSource_titles;
	private static DataSource dataSource_ignoreWords;
	
	public static void run(String[] titles, String[] ignored_words) {
		
		long startTime = System.currentTimeMillis();

		dataSource_titles =  new DataSource(titles);
		dataSource_ignoreWords =  new DataSource(ignored_words);

		//Init Pipe
		Pipe pipe_processTitle = new Pipe();
		Pipe pipe_processIgnoreWords = new Pipe();
		Pipe pipe_CaptureTitle = new Pipe();
		
		//Init kwic-index
		LinkedList<String> kwic_index = new LinkedList<String>();
		
		//First Process words to ignore
		pipe_processTitle.setArrValue(dataSource_titles.getData());
		Filter_ProcessTitles processTitles = 
				new Filter_ProcessTitles(pipe_processTitle);
		
		//Second Process titles
		pipe_processIgnoreWords.setArrValue(dataSource_ignoreWords.getData());
		Filter_ProcessIgnoreWords processIgnoreWords = 
				new Filter_ProcessIgnoreWords(pipe_processIgnoreWords);	
		
		//Capture origin title
		Pipe pipe_processedTitles = new Pipe();
		pipe_processedTitles.setArrValue(processTitles.getProcessedData());
		
		//Loop through each title
		for(String s : pipe_processedTitles.getArrValue()) {
			
			while(true) {
				
				//Init pipe with current original title
				Pipe pipe_captureTitle = new Pipe();
				pipe_captureTitle.setStrValue(s);
				
				//Capture original title
				Filter_CaptureTitle captureOriginalTitle = 
						new Filter_CaptureTitle(pipe_processedTitles);	
				
				//To check for words to ignore
				Pipe pipe_ToCheckIgnoreWords = new Pipe();
				pipe_ToCheckIgnoreWords.setStrValue(captureOriginalTitle.getProcessedData());
				pipe_ToCheckIgnoreWords.setArrValue(processIgnoreWords.getProcessedData());
				
				
				Filter_CheckIgnoreWords checkWordsToIgnore =
						new Filter_CheckIgnoreWords(pipe_ToCheckIgnoreWords);
				
				boolean isWordToIgnore = checkWordsToIgnore.getProcessedData();
				
				//If is not word to ignore, Append to list before continuing
				if(!isWordToIgnore) { 
					Pipe pipe_appendNewTitle = new Pipe();
					pipe_appendNewTitle.setStrValue(pipe_ToCheckIgnoreWords.getStrValue());
					pipe_appendNewTitle.setLinkedListValue(kwic_index);
					
					Filter_AppendNewTitle appendNewTitle = 
							new Filter_AppendNewTitle(pipe_appendNewTitle);
					
					kwic_index = appendNewTitle.getProcessedData();
				}
				
				//Rotate Title aka Circular Shift the title
				Pipe pipe_toRotateTitle = new Pipe();
				pipe_toRotateTitle.setStrValue(pipe_ToCheckIgnoreWords.getStrValue());
				
				Filter_RotateTitle rotateTitle = new Filter_RotateTitle(pipe_toRotateTitle);
				
				Pipe pipe_fromRotateTitle = new Pipe();
				String[] checkTitles = null;
				checkTitles[0] = s;
				checkTitles[1] = rotateTitle.getProcessedData();
				pipe_fromRotateTitle.setArrValue(checkTitles);
				
				//Check if is original title
				Filter_CheckOriginalTitle checkOriTitle =
						new Filter_CheckOriginalTitle(pipe_fromRotateTitle);
				
				//If is original title
				if(checkOriTitle.getProcessedData()) {
					break;
				}
			}
			
			//Rotate title
			
			//Check if Original Title
			//if not then continue check for words to ignore
			//if original check if title = last title in given list
				//if not then go ti step 3 capture origin title
				//if yes thne sortAppendList
			
			
		}
		
		Pipe toSortAppendList = new Pipe();
		toSortAppendList.setLinkedListValue(kwic_index);
		
		Filter sortAppendList = new Filter_SortAppendList(toSortAppendList);
		
		//Finally parse to data sink
		Pipe fromSort_toDataSink = new Pipe();
		fromSort_toDataSink.setLinkedListValue(sortAppendList.getProcessedData());
		
		DataSink dataSink =  new DataSink(fromSort_toDataSink);
		
		dataSink.outputData();
		
		//Output timetaken
		System.out.println(startTime);
		
		
	}
}
