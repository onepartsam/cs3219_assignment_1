package ADT;

import java.util.LinkedList;

public class ADTMain {
	
	private final static String INSERT_TITLE_MESSAGE = "Please enter each %s in seperate lines.\n";
	private final static String TITLE = "title";
	private final static String IGNORED_WORD = "ignored word";
	
	public static void main(String[] args) {
		
		ADTCharacters characters = new ADTCharacters ();
		
		populateTitles(characters);
		populateWordsToIgnore(characters);
		
		System.out.println(characters.getTitles());
		System.out.println(characters.getIgnoredWords());
	}

	private static void populateTitles (ADTCharacters characters) {
		
		System.out.printf(INSERT_TITLE_MESSAGE, TITLE);
		LinkedList<String> titles = ADTInput.inputTitles();
		characters.insertTitles(titles);
	}

	private static void populateWordsToIgnore (ADTCharacters characters) {
		
		System.out.printf(INSERT_TITLE_MESSAGE, IGNORED_WORD);
		LinkedList<String> wordsToIgnore = ADTInput.inputWordsToIgnore();
		characters.insertIgnoredWords(wordsToIgnore);
	}

}
