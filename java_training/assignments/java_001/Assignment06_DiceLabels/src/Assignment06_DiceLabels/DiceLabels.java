/**
 * 
 */
package Assignment06_DiceLabels;

/**
 * @author alice
 *
 */
public class DiceLabels {
	
	private static String[][] rolls = {
			{"Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six", "Six one you're done"},
			{"Ace caught a deuce", "Ballerina", "The fever", "Jimmie Hicks", "Benny Blue", "Easy eight"},
			{"Easy four", "OJ", "Brooklyn Forest", "Big Red", "Eighter from Decatur", "Nina from Pasadena"},
			{"Little Phoebe", "Easy six", "Skiny McKinney", "Square pair", "Railroad nine", "Big one on the end"},
			{"Sixie from Dixie", "Skinny Dugan", "Easy eight", "Jesse James", "Puppy paws", "Yo"},
			{"The Devil", "Easy eight", "Lou Brown", "Tennessee", "Six five no jive", "Midnight"}
	};
	
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
	
	public static void printGrid() {
		String[] firstLine = {"*", "Die 1", "Die 2", "Die 3", "Die 4", "Die 5", "Die 6"};
		printLine(firstLine);
		for (int row=0; row<rolls.length; row++) {
			String[] label = { String.format("Die %d", row+1) };
			printLine( concatArrays(label, rolls[row]) );
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		printGrid();
	}

}
