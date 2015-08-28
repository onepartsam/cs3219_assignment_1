package ADT;

import java.util.LinkedList;
import java.util.Scanner;

public class ADTInput {
	
	final private String WELCOME_MESSAGE = "Thank you for choosing the Abstract Data Type method.";
	private Scanner scanner;
	private LinkedList<String> ignoredWords;
	
	public ADTInput() {
		
		this.scanner = new Scanner (System.in);
		System.out.println(WELCOME_MESSAGE);
		
		ignoredWords = wordsToIgnore ();
	}
	
	public LinkedList<String> getIgnoredWords () {
		
		return ignoredWords;
	}
	
	private LinkedList<String> wordsToIgnore () {
		
		LinkedList<String> ignoredWords = new LinkedList<String> ();
		String ignoreWord = "";
		
		while (true) {
			
			ignoreWord = scanner.nextLine();
			ignoreWord = ignoreWord.toLowerCase();
			
			if (ignoreWord.equals("<exit>")) {
				break;
			} else {
				ignoredWords.add(ignoreWord);
			}
		}
		
		return ignoredWords;
	}
}
