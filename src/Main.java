
import java.util.Scanner;

import ADT.ADTMain;
import DataFlow.DataFlowMain;

public class Main {

	// Constant Variable(s)
	final static int ARCHI_TYPE_START_INDEX = 100;
	final static String WELCOME_MESSAGE = "Hello there!\n";
	final static String REQUEST_KEYWORD_MESSAGE = "Please input a list of keywords to ignore, each word separated by a comma:\n";
	final static String REQUEST_TITLE_MESSAGE = "Please input a list of title, each title separated by a comma:\n";
	final static String ERROR_INPUT_MESSAGE = "Invalid input, please try again: ";
	final static String SUCCESS_INPUT_MESSAGE = "You've selected option %d. Please standby.";
	final static String CONTINUE_MESSAGE = "Do you want to conitnue? 1 to continue 2 to exit program:";
	final static String SELECTION_MESSAGE = "\nPlease select either one option to begin:"
			+ "\n 1. Abstract Data Types Method" + "\n 2. Pipes and Filter Method" + "\n 3. Both Methods"
			+ "\n\nYour option: ";
	final static String EXIT_MESSAGE = "Thank you for using our system. Goodbye.";

	// Class Variables
	static int userOption = -1;
	static int userContOption = -1;
	static boolean debug_mode = false; // Set to false if debug mode is not
										// needed
	static String keywords = "";
	static String titles = "";

	// Class Objects
	static Scanner scanner = null;
	static String[] ignoredWordsList;
	static String[] title_list;

	public static enum DataType {

		KEYWORD, TITLE, END_OF_LIST
	}

	public static enum ArchiDesignType {

		START_OF_LIST(ARCHI_TYPE_START_INDEX), // DO NOT REMOVE, ADD NEW
												// STRUCTURES BELOW
		ADT(101), DATAFLOW(102), BOTH(103), END_OF_LIST(104); // DO NOT REMOVE,
																// ADD NEW
																// STRUCTURES
																// ABOVE

		private int value;

		private ArchiDesignType(int val) {
			this.value = val;
		}

		public int getValue() {
			return value;
		}
	}

	public static void main(String[] args) {

		// Initiates Objects
		scanner = new Scanner(System.in);
		// ADT adt_factor = new ADT();
		DataFlowMain method_dataflow = new DataFlowMain();

		///////////////////////////////////////////////////////////
		///////////////////// Main program//////////////////////////
		///////////////////////////////////////////////////////////

		System.out.print(WELCOME_MESSAGE);

		// Handles Keywords to Ignore
		System.out.print(REQUEST_KEYWORD_MESSAGE);
		keywords = scanner.nextLine();
		ignoredWordsList = tokenizeString(keywords);

		// Handles List of Titles
		System.out.print(REQUEST_TITLE_MESSAGE);
		titles = scanner.nextLine();
		title_list = tokenizeString(titles);// , title_list);

		////////////// For Debugging purposes///////////////////////
		if (debug_mode) {
			System.out.print("\n\n");

			for (String s : ignoredWordsList) {
				System.out.print(s + "\n");
			}

			for (String s : title_list) {
				System.out.print(s + "\n");
			}

			System.out.print("\n\n");
		}
		////////////////////////////////////////////////////////////

		while (true) {

			System.out.print(SELECTION_MESSAGE);

			userOption = scanner.nextInt();
			userOption += ARCHI_TYPE_START_INDEX;

			// ***TO SAM - Sorry i change your code for the program's
			// expandability***//

			if (userOption <= ArchiDesignType.START_OF_LIST.getValue()
					|| userOption >= ArchiDesignType.END_OF_LIST.getValue()) {
				System.out.print(ERROR_INPUT_MESSAGE);
			} else {

				// ArchiDesignType userChoice = ArchiDesignType()[userOption];

				// Calls relative method to user's input choice //DUMMY FUNCTION
				// BELOW - REMOVE WHEN SUBMISSION
				// For debug
				// System.out.printf(SUCCESS_INPUT_MESSAGE,
				// userOption-ARCHI_TYPE_START_INDEX);
				if (userOption == ArchiDesignType.ADT.getValue()) {

					ADTMain.run(title_list, ignoredWordsList);

				} else if (userOption == ArchiDesignType.DATAFLOW.getValue()) {

					DataFlowMain dataFlow = new DataFlowMain();
					dataFlow.run(title_list, ignoredWordsList);
				} else if (userOption == ArchiDesignType.BOTH.getValue()) {

					
					DataFlowMain dataFlow = new DataFlowMain();
					dataFlow.run(title_list, ignoredWordsList);ADTMain.run(title_list, ignoredWordsList);
				}

				// ------------KIV-----------------------------------------------------------//
				// switch(userOption){
				//
				// case ADT:
				// //For debugging purpose
				// System.out.printf(SUCCESS_INPUT_MESSAGE, userOption);
				// break;
				// case DATAFLOW:
				// //For debugging purpose
				// System.out.printf(SUCCESS_INPUT_MESSAGE, userOption);
				// break;
				//
				// default:
				// System.out.print(ERROR_INPUT_MESSAGE);
				// break;
				// }
				//
				// ------------KIV------------------------------------------------------------//
			}

			System.out.println("\n" + CONTINUE_MESSAGE);
			userContOption = scanner.nextInt();

			if (userContOption != 1) {
				System.out.println("\n" + EXIT_MESSAGE);
				System.exit(0);
			}
		}
	}

	public static String[] tokenizeString(String inString) {

		// Local Variables Declaration
		String[] outArray = null;

		// Tokenization of String
		outArray = inString.split(",");

		// Removing all leading and trailing whitespaces before tokenizing.
		for (short i = 0; i < outArray.length; i++) {
			outArray[i] = outArray[i].trim().toLowerCase();
		}

		return outArray;
	}
}