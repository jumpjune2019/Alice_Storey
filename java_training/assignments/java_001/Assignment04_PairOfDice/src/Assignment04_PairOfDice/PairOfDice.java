/**
 * 
 */
package Assignment04_PairOfDice;

import java.util.Scanner;

/**
 * @author alice
 *
 */
public class PairOfDice {

	private static int roll1d6() {
		int result = 0;
		double ran = Math.random();
		result = (int)(6*ran);
		result++;
		return result;
	}
	
	private static void displayRolls() {
		System.out.printf("First Die: %d\nSecond Die: %d\n", roll1d6(), roll1d6());		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws java.io.IOException {
		final String MESSAGE = "Press any key to throw a die and press Enter (or Q and Enter to quit):",
				PROMPT = "Play Again? (Y or y) and Enter, any other key and Enter to Quit:";
		char input;
		String inputString;
		boolean quit = false;
		Scanner scan = new Scanner(System.in);		
		
		
		System.out.print(MESSAGE);
		//input = (char) System.in.read();
		inputString = scan.nextLine();
		input = inputString.charAt(0);
		if (input == 'q' || input=='Q') {
			quit = true;
		}
		else {
			displayRolls();
		}
		
		
		
		while (!quit) {
			System.out.println(PROMPT);
			inputString = scan.nextLine();
			input = inputString.charAt(0);
			//input = (char) System.in.read(); //abandoned for Scanner, because this was being skipped due to buffer
			if (input == 'y' || input == 'Y') {
				displayRolls();
			}
			else {
				quit = true;
			}
		}
		
		scan.close();
		
	}

}
