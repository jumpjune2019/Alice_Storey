import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.PrintStream;
import java.util.Scanner;

class UserInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserInputException (String errorMessage) {
		super (errorMessage);
	}
}

class MatrixOutOfBoundsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MatrixOutOfBoundsException (String errorMessage) {
		super (errorMessage);
	}
}

public class matrixcustomhandlers {

	private static String[][] rolls = {
			{"Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six", "Six one you're done"},
			{"Ace caught a deuce", "Ballerina", "The fever", "Jimmie Hicks", "Benny Blue", "Easy eight"},
			{"Easy four", "OJ", "Brooklyn Forest", "Big Red", "Eighter from Decatur", "Nina from Pasadena"},
			{"Little Phoebe", "Easy six", "Skiny McKinney", "Square pair", "Railroad nine", "Big one on the end"},
			{"Sixie from Dixie", "Skinny Dugan", "Easy eight", "Jesse James", "Puppy paws", "Yo"},
			{"The Devil", "Easy eight", "Lou Brown", "Tennessee", "Six five no jive", "Midnight"}
	};
	
	private final static String FILENAME = "dice_labels.txt";
	
	private static String[] concatArrays(String[] a, String[] b) {
		String[] result = new String[a.length + b.length];
		
		int counter = 0;
		for (String item : a) {
			result[counter] = new String(item);
			counter++;
		}
		for (String item : b) {
			result[counter] = new String(item);
			counter++;
		}
		
		return result;
	}
	
	private static void printLine(String[] text) {
		for (String item : text) {
			System.out.printf("%-24s",item);
		}
		System.out.println();
	}
	
	public static void printGrid(PrintStream output) throws MatrixOutOfBoundsException{
		try {
			System.setOut(output);
			String[] firstLine = {"*", "Die 1", "Die 2", "Die 3", "Die 4", "Die 5", "Die 6"};
			printLine(firstLine);
			for (int row=0; row<rolls.length; row++) {
				String[] label = { String.format("Die %d", row+1) };
				printLine( concatArrays(label, rolls[row]) );
			}
		} catch (IndexOutOfBoundsException e) {
			throw new MatrixOutOfBoundsException("Error when referring to a matrix element.");
		}
		
	}
	
	
	private static boolean getInput(Scanner scan) throws MatrixOutOfBoundsException, UserInputException, FileNotFoundException, IOError {
		PrintStream console = System.out;
		try {
			String inputString = "";
			while (inputString.length() < 1) {
				inputString = scan.nextLine();
			}
			char input = inputString.charAt(0);
		
			PrintStream fileout;
			switch (input) {
				case 'q':
					return false;
				case 'Q':
					return false;
				case '1':
					printGrid(console);
					break;
				case '2':
					fileout = new PrintStream(new File(FILENAME)); 
					printGrid(fileout);
					fileout.close();
					break;
				case '3':
					printGrid(console);
					fileout = new PrintStream(new File(FILENAME)); 
					printGrid(fileout);
					fileout.close();
					break;
				default:
					throw new UserInputException("Did not recognize user input.");
			}
			
		}
		catch(IOError e) {
			throw e;
		}
		catch(FileNotFoundException e) {
			throw e;
		}
		catch (UserInputException e) {
			throw e;
		}
		catch (MatrixOutOfBoundsException e) {
			throw e;
		}
		return true;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String MESSAGE = "\nOptions - (1) print to screen  (2) print to file  (3) both  (q) quit:";
		
		Scanner scan = new Scanner(System.in);	
		PrintStream console = System.out;
		boolean quit = false;
		
		while (!quit) {
			System.setOut(console);
			System.out.print(MESSAGE);
			try {
				quit = (!getInput(scan));
			}
			catch (IOError e) {
				System.setOut(console);
				System.out.println(e);
			}
			catch (FileNotFoundException e) {
				System.setOut(console);
				System.out.println(e);
			}
			catch (MatrixOutOfBoundsException e) {
				System.setOut(console);
				System.out.println(e);
			}
			catch (UserInputException e) {
				System.setOut(console);
				System.out.println(e);
			}
		}
	}

}
