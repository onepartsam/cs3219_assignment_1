// @author  Bay Chuan Wei

package DataFlow;

import java.util.LinkedList;

public class DataSink {
	
	private final String BULLET = " > ";
	
	private LinkedList<String> data;
	
	DataSink(Pipe inPipe){
		
		data = inPipe.getLinkedListValue();
	}
	
	
	public void outputData (){
		
		for(String s: data){
			System.out.println(BULLET + s);
		}

	}
}
