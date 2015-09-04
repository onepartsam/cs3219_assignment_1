// @author  Bay Chuan Wei

package DataFlow;

import java.util.Collections;
import java.util.LinkedList;

public class Filter_SortAppendList extends Filter {

	//Class Variables & Objects
	private LinkedList<String>  newList;
	
	Filter_SortAppendList(Pipe inPipe) {
		super(inPipe);
		processData();
	}
	
	@Override
	public void processData() {
		
		newList = sortList(pipe.getLinkedListValue());
		
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
			
			//Appends bck capitalized word
			tempNewTitle = outArray[0] + " " + outArray[1] ; 
			
			
			newTempList.add(tempNewTitle);
		}
		
		return newTempList;
	}
	
};