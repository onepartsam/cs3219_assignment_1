package DataFlow;

import java.util.LinkedList;

public class DataSink {
	
	private LinkedList<String> data;
	
	DataSink(Pipe inPipe){
		
		data = inPipe.getLinkedListValue();
	}
	
	
	public void outputData (){
		
		for(String s: data){
			System.out.println(s);
		}

	}
}
