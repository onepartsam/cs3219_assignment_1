package ADT;

import java.util.LinkedList;

public class ADTMain {

	public static void run(String[] titles, String[] ignored_words) {
		
		long startTime = System.currentTimeMillis();

		ADTCharacters characters = new ADTCharacters();
		LinkedList<String> processed_all_titles = new LinkedList<String>();
		LinkedList<String> processed_titles;
		String title = "";

		characters.insertTitles(titles);
		characters.insertIgnoredWords(ignored_words);

		for (int i = 0; i < characters.getTitles().length; i++) {

			title = characters.getTitles()[i];
			processed_titles = ADTCircularShift.process(title, characters.getIgnoredWords());
			processed_all_titles.addAll(processed_titles);
		}
		
		ADTOutput.output(processed_all_titles, startTime);
	}
}
