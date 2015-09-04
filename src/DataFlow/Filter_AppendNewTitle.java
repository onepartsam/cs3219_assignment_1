// @author  Bay Chuan Wei

package DataFlow;

import java.util.LinkedList;

public class Filter_AppendNewTitle extends Filter {

	//Class Variables & Objects
	private String newTitle;
	private LinkedList<String> kwicIndex;
	
	Filter_AppendNewTitle(Pipe inPipe) {
		super(inPipe);
		processData();
	}
	
	@Override
	public void processData() {
		
		newTitle = pipe.getStrValue();
		kwicIndex = pipe.getLinkedListValue();
		kwicIndex.add(newTitle);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public LinkedList<String> getProcessedData() {

		return kwicIndex;
	}
	
};