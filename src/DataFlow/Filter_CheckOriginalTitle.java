// @author  Bay Chuan Wei

package DataFlow;

public class Filter_CheckOriginalTitle extends Filter {

	//Class Variables & Objects
	private boolean isOriginalTitle;
	private String originalTitle;
	private String currentTitle;
	
	Filter_CheckOriginalTitle(Pipe inPipe) {
		super(inPipe);
		processData();
	}
	
	@Override
	public void processData() {
		
		originalTitle = pipe.getArrValue()[0];
		currentTitle = pipe.getArrValue()[1];
		
		isOriginalTitle = originalTitle.equalsIgnoreCase(currentTitle);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Boolean getProcessedData() {

		return isOriginalTitle;
	}
	
};