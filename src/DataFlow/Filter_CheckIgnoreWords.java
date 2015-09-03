package DataFlow;

public class Filter_CheckIgnoreWords extends Filter {

	//Class Variables & Objects
	private static String[] keywords;
	private static String title;
	private static boolean isWordToIgnore;
	
	Filter_CheckIgnoreWords(Pipe inPipe) {
		super(inPipe);
	}
	
	@Override
	public void processData() {
		
		keywords = pipe.getArrValue();
		title = pipe.getStrValue();
		
		String extractedKeyword = extractKeyword (title);
		isWordToIgnore = checkIsWordToIgnore(extractedKeyword);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean getProcessedData() {

		//the '!' is to reverse the output so that if its wordsToIgnore 
		//then its not a keyword thus it will return false otherwise if 
		// it is not a word to ignore then it is a keyword then it will 
		//return true
		return !isWordToIgnore; 
	}
	
	private String extractKeyword (String inTitle) {
		
		String extractedKeyword = "";
		
		extractedKeyword = inTitle.substring(0, inTitle.indexOf(' '));
		return extractedKeyword;
	}
	
	private boolean checkIsWordToIgnore (String extractedKeyword) {
		
		//This is implemented for user friendliness non-function feature.
		String lowerCaseExKeyword = extractedKeyword.toLowerCase();
		
		for(String word:keywords) {
			
			if(word.toLowerCase().equals(lowerCaseExKeyword)) {
				return true;
			}
		}
		return false;
	}
	
};