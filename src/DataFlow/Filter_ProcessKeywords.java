package DataFlow;

public class Filter_ProcessKeywords extends Filter {

	//Class Variables & Objects
	private String[] keywords;
	
	Filter_ProcessKeywords(Pipe inPipe) {
		super(inPipe);
	}
	
	@Override
	public void processData() {
		
		keywords = pipe.getArrValue();
		
		//trim leading and preceeding whitespaces.
		for(int i = 0; i < keywords.length; i++) {
			keywords[i] = keywords[i].trim();
		}
		
		pipe.setArrValue(keywords);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String[] getProcessedData() {

		return pipe.getArrValue();
	}
	
	
	
};