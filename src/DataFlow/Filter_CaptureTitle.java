package DataFlow;

public class Filter_CaptureTitle extends Filter {

	//Class Variables & Objects
	private String originalTitle;
	
	Filter_CaptureTitle(Pipe inPipe) {
		super(inPipe);
	}
	
	@Override
	public void processData() {
		
		originalTitle = pipe.getStrValue().trim();
		
		pipe.setStrValue(originalTitle);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getProcessedData() {

		return pipe.getStrValue();
	}
	
};