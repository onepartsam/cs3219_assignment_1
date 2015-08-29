package DataFlow;

public abstract class Filter {
	
	Pipe pipe; //The input data to be process would be contained in a pipe
	
	//Constructor
	Filter(Pipe inPipe) {
		
		pipe = inPipe;
	}
	
	//Getters
	Pipe getPipe() {	
		return pipe; //returns the pipe with the processed data
	}
	
	//Base Function required for inheritence (forced implmentation.)
	public abstract void processData ();
	public abstract <T> T getProcessedData ();
	
};