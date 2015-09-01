package ADT;

import java.util.LinkedList;
import java.util.Scanner;

public class ADTInput {

	private final static String ENTER_MESSAGE = "%s #%d: ";
	private final static String TITLE = "Title";
	private final static String IGNORED_WORD = "Ignored Word";

	private static Scanner scanner;

	public static LinkedList<String> inputWordsToIgnore() {

		LinkedList<String> ignoredWords = inputLines(IGNORED_WORD);
		return ignoredWords;
	}

	public static LinkedList<String> inputTitles() {

		LinkedList<String> titles = inputLines(TITLE);
		return titles;
	}

	private static LinkedList<String> inputLines(String keyword) {

		LinkedList<String> lines = new LinkedList<String>();
		String line = "";
		int index = 1;

		scanner = new Scanner(System.in);

		while (true) {

			System.out.printf(ENTER_MESSAGE, keyword, index);
			line = scanner.nextLine();

			line = stripSpaces(line);

			if (line.equals("<exit>")) {
				break;
			} else {
				lines.add(line);
				index++;
			}
		}

		return lines;
	}

	private static String stripSpaces(String line) {

		return line.replaceAll("\\s+", " ").trim();
	}
}
