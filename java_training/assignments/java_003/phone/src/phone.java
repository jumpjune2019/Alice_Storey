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

public class phone {

	private static final int NAME=0, PHONE=1, CITY=2;
	private static final String FILENAME = "phone.txt";
	private static final String[] HEADER = {"Name", "Phone", "City"};	
	
	private static String[][] grid = new String[5][3];	
	private static int size = 0;

	
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
			printLine(HEADER);
			for (int row=0; row<grid.length; row++) {
				printLine( grid[row] );
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
	
	private static String[] getInputRow(Scanner scan) throws UserInputException {
		
		String inputString = "";
		while (inputString.length() < 1) {
			inputString = scan.nextLine();
		}
		
		String[] row = inputString.split("\t", grid[0].length);
		
		//just in case tabs weren't used here's a fallback
		if (row.length == 1) {
			row = inputString.split("\\s", grid[0].length);
		}
		
		return row;
	}
	
	private static char getInputChar (Scanner scan) {
		
		String inputString = "";
		while (inputString.length() < 1) {
			inputString = scan.nextLine();
		}
		return inputString.charAt(0);		
	
	}
	
	public static void main(String[] args) {
		
		
		final String MESSAGE = "\nOptions - (1) print to screen  (2) print to file  (3) both  (q) quit:",
				TITLE = "PhoneBook App",
				PROMPT = "Enter contact data, tab delimited (%d entries):\n",
				CONFIRM = "Is this correct? (y/n):",
				LINESTART = ">";
		
		Scanner scan = new Scanner(System.in);	
		PrintStream console = System.out;
		boolean quit = false;
		
		//get input for contact entries
		System.setOut(console);
		System.out.println(TITLE);
		System.out.printf(PROMPT, grid.length);
		printLine(HEADER);
		
		while(size < grid.length) {
			try {
				char confirmYN='n';
				
				while (confirmYN != 'y') {
					System.out.print(LINESTART);
					String[] row =	getInputRow(scan);
					printLine(row);
					
					do {
						System.out.print(CONFIRM);
						confirmYN = getInputChar(scan);
					} while (confirmYN != 'y' && confirmYN != 'n');
					
					grid[size] = row;
					size++;
				}
				
			}
			catch (UserInputException e) {
				System.setOut(console);
				System.out.println(e);
			}
		}
		
		//get input for output and file saving
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
