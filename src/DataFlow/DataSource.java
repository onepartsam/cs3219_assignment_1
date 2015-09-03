package DataFlow;

public class DataSource {

	private String[] data;
	
	DataSource(String[] inData){
		
		data = inData;
	}
	
	
	public String[] getData (){
		return data;
	}
}
