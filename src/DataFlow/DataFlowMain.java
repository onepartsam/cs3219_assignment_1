package DataFlow;

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
		Pipe dataFlowPipe = new Pipe();
		
		//First Process words to ignore
		dataFlowPipe.setArrValue(dataSource_titles.getData());
		
		//Second Process titles
		
		//Capture origin title
		
		//Check for words to ignore - while true here
		//ifelse here
		
		//Rotate title
		
		//Check if Original Title
		//if not then continue check for words to ignore
		//if original check if title = last title in given list
			//if not then go ti step 3 capture origin title
			//if yes thne sortAppendList
		
		
		//Finally parse to data sink
		Pipe toDataSink = new Pipe();
		DataSink dataSink =  new DataSink(toDataSink);
		
		dataSink.outputData();
		
		//Output timetaken
		System.out.println(startTime);
		
		
	}
}
