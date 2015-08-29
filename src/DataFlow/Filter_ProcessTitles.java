package DataFlow;

public class Filter_ProcessTitles extends Filter {

	//Class Variables & Objects
	private String[] titles;
	
	Filter_ProcessTitles(Pipe inPipe) {
		super(inPipe);
	}
	
	@Override
	public void processData() {
		
		titles = pipe.getArrValue();
		
		//trim leading and preceeding whitespaces.
		for(int i = 0; i < titles.length; i++) {
			titles[i] = titles[i].trim();
		}
		
		pipe.setArrValue(titles);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String[] getProcessedData() {

		return pipe.getArrValue();
	}
};