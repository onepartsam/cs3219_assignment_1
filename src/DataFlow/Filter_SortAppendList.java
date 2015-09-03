package DataFlow;

import java.util.Collections;
import java.util.LinkedList;

public class Filter_SortAppendList extends Filter {

	//Class Variables & Objects
	private LinkedList<String>  newList;
	
	Filter_SortAppendList(Pipe inPipe) {
		super(inPipe);
	}
	
	@Override
	public void processData() {
		
		newList = pipe.getLinkedListValue();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public LinkedList<String> getProcessedData() {

		return newList;
	}
	
	
	public LinkedList<String> sortList(LinkedList<String> inList) {

		LinkedList<String> newTempList = new LinkedList<String>();
		LinkedList<String> tempList = inList;
		
		Collections.sort(tempList);
		
		for(int i = 0; i < tempList.size(); i++) {
			
			String[] outArray = tempList.get(i).split(" ", 2);
			String tempNewTitle = "";
			
			//Changes keyWord to caps - outArray[0]
			outArray[0] = outArray[0].toUpperCase();
			
			//Changes the rest to lower case
			outArray[1] = outArray[1].toLowerCase();
			
			//Appends first word to the back of the string
			tempNewTitle = outArray[1] + " " + outArray[0]; 
			
			newTempList.add(tempNewTitle);
		}
		
		return newTempList;
	}
	
};