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
	private final static String FILENAME = "dice_labels.txt";
	
	private static String[][] grid = new String[5][3];
	
	
	

	
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
			String[] firstLine = {"Name", "Phone", "City"};
			printLine(firstLine);
			for (int row=0; row<grid.length; row++) {
				String[] label = { String.format("Die %d", row+1) };
				printLine( concatArrays(label, grid[row]) );
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
	
	public static void main(String[] args) {
		
		
		

	}

}
