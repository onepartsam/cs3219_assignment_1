// @author  Samuel Lim

package ADT;

import java.util.Arrays;
import java.util.LinkedList;

public class ADTCircularShift {

	public static LinkedList<String> process(String title, String[] ignored_words) {

		title = cleanupTitle(title);
		LinkedList<String> list_ignored_words = new LinkedList<String>(Arrays.asList(ignored_words));

		return circularShift(title, list_ignored_words);
	}

	// Ensures that the title doesn't have multiple spaces
	private static String cleanupTitle(String title) {

		return title.replaceAll("\\s+", " ").trim();
	}

	// Ensures that the title doesn't have multiple spaces
	private static LinkedList<String> circularShift(String title, LinkedList<String> ignored_words) {

		String[] words = getWords(title);
		LinkedList<String> processed_titles = new LinkedList<String>();

		for (int i = 0; i < words.length; i++) {

			String word = words[0].toLowerCase();

			if (!ignored_words.contains(word)) {

				String process_title = combineWords(words);
				processed_titles.add(process_title);
			}

			shift(words);
		}

		return processed_titles;
	}

	private static String combineWords(String[] words) {

		String title = words[0].toUpperCase();

		for (int i = 1; i < words.length; i++) {
			title = title + " " + words[i].toLowerCase();
		}

		return title;
	}

	private static String[] shift(String[] words) {

		String temp_word = words[0];

		for (int i = 1; i < words.length; i++) {
			words[i - 1] = words[i];
		}

		words[words.length - 1] = temp_word;

		return words;
	}

	private static String[] getWords(String title) {
		return title.split(" ");
	}

}
