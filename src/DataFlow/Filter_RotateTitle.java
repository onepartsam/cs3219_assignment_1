package DataFlow;


public class Filter_RotateTitle extends Filter {

	//Class Variables & Objects
	private String newTitle;
	private String oldTitle;
	
	Filter_RotateTitle(Pipe inPipe) {
		super(inPipe);
	}
	
	@Override
	public void processData() {
		
		oldTitle = pipe.getStrValue();
		newTitle = rotateTitle (oldTitle);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getProcessedData() {

		return newTitle;
	}
	
	private String rotateTitle (String inOldTitle) {
		
		String tempOldTitle = inOldTitle;
		String tempNewTitle = "";
		
		//Splits the current title into an array of 2 with the first
		//element as the first word and the 2nd element as the rest 
		//of the sentence.
		String[] outArray = tempOldTitle.split(" ", 2);
		
		//Appends first word to the back of the string
		tempNewTitle = outArray[1] + " " + outArray[0]; 
		
		return tempNewTitle;
	}
	
};