package ADT;

import java.util.Collections;
import java.util.LinkedList;

public class ADTOutput {

	private final static String DIVIDER =
			"\n===============================";
	private final static String RESULT_MESSAGE =
			DIVIDER + "\nADT Output titles:" + DIVIDER;
	private final static String TIME_TAKEN_MESSAGE =
			"Total time taken: %d ms\n";
	private final static String BULLET = " > ";
	
	public static void output(LinkedList<String> titles, long startTime) {
		
		Collections.sort(titles);
		
		System.out.println(RESULT_MESSAGE);
		
		displayTitles(titles);
		displayTimeTaken(startTime);
	}

	private static void displayTitles(LinkedList<String> titles) {

		for (int i = 0; i < titles.size(); i++) {
			System.out.println(BULLET + titles.get(i));
		}
	}

	private static void displayTimeTaken(long startTime) {

		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.printf(TIME_TAKEN_MESSAGE, timeTaken);
	}
	
	
}