import java.util.Scanner;

public class Main {
	
	// Constant Variable(s)
	final static String WELCOME_MESSAGE = "Hello there! Please select either one option to begin:" +
											"\n 1. Abstract Data Types Method" +
											"\n 2. Pipes and Filter Method" +
											"\n\nYour option: ";
	final static String ERROR_INPUT_MESSAGE = "Invalid input, please try again: ";
	final static String SUCCESS_INPUT_MESSAGE = "You've selected option %d. Please standby.";
	
	// Class Variables
	static Scanner scanner = null;
	static int userOption = -1;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		System.out.print(WELCOME_MESSAGE);
		
		while (true) {
			userOption = scanner.nextInt();
			
			if (userOption != 1 && userOption != 2) {
				System.out.print(ERROR_INPUT_MESSAGE);
			} else {
				System.out.printf(SUCCESS_INPUT_MESSAGE, userOption);
				break;
			}
		}
	}

}