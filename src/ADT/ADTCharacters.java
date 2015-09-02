package ADT;

import java.util.LinkedList;

public class ADTCharacters {
	
	private LinkedList<String> ignoredWords;
	private LinkedList<String> titles;

	public ADTCharacters () { }
	
	
	public LinkedList<String> getTitles() {

		return titles;
	}
	
	public LinkedList<String> getIgnoredWords() {

		return ignoredWords;
	}
	
	
	public LinkedList<String> insertTitles(LinkedList<String> titles) {

		this.titles = titles;
		return titles;
	}
	
	public LinkedList<String> insertIgnoredWords(LinkedList<String> ignoredWords) {

		this.ignoredWords = ignoredWords;
		return ignoredWords;
	}
}
