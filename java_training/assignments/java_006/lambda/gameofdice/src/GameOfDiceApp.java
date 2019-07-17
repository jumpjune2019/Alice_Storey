import java.util.Scanner;

public class GameOfDiceApp {
	private static final String MESSAGE = "Welcome to the dice throw challenge!\nDo you feel lucky? \"Punk\"... Do ya?\nPress any key and ENTER to throw your dice or press (Q or q) to chicken your butt off...",
			PROMPT = "Wanna try again? Press any key and ENTER to throw your dice or press (Q or q) to quit:";
	public static final int PLAYER=0, COMPUTER=1;
	private static final String[][] rollNames = {
		{"Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six", "Six one you're done"},
		{"Ace caught a deuce", "Ballerina", "The fever", "Jimmie Hicks", "Benny Blue", "Easy eight"},
		{"Easy four", "OJ", "Brooklyn Forest", "Big Red", "Eighter from Decatur", "Nina from Pasadena"},
		{"Little Phoebe", "Easy six", "Skiny McKinney", "Square pair", "Railroad nine", "Big one on the end"},
		{"Sixie from Dixie", "Skinny Dugan", "Easy eight", "Jesse James", "Puppy paws", "Yo"},
		{"The Devil", "Easy eight", "Lou Brown", "Tennessee", "Six five no jive", "Midnight"}
	};
	
	
	
	interface Dice<T> {
		T get(int a, int b);
	}
	
	private static int[][] rolls  = new int[2][2];
	private static Dice<Integer> roll = (a,b) -> (a* (int) (b*Math.random())+1);
	private static Dice<String> rollName = (a,b) -> rollNames[a-1][b-1];
	private static Dice<Boolean> isDouble = (a,b) -> rolls[a][0] == rolls[a][1];
	
	/**
	 * @param who
	 * 1 for player, 2 for computer
	 */
	private static void rollMessage(int who) {
		String pronoun = (who==PLAYER) ? "You" : "I";		
		rolls[who][0] = roll.get(1,6);
		rolls[who][1] = roll.get(1, 6);
		System.out.printf("%s have rolled a %d and %d > the %s\n", pronoun, rolls[who][0], rolls[who][1], rollName.get(rolls[who][0], rolls[who][1]) );
	}
	
	
	private static boolean getInput(Scanner scan) {
		String inputString = "";
		while (inputString.length() < 1) {
			inputString = scan.nextLine();
		}
		char input = inputString.charAt(0);
		if (input == 'q' || input=='Q') {
			return false;
		}
		else {
			return true;
		}
	}
	
	private static void scoreMessage() {
		int playerSum = rolls[PLAYER][0] + rolls[PLAYER][1],
		computerSum = rolls[COMPUTER][0] + rolls[COMPUTER][1];
		
		if (playerSum < computerSum) {
			System.out.print("I win!!!\nWanna try again? ");
		}
		else if (playerSum > computerSum) {
			System.out.print("You win!!!\nDid you cheat?? Gimme another try, c'mon ");
		}
		else {
			boolean playerDouble = isDouble.get(PLAYER,PLAYER),
					computerDouble = isDouble.get(COMPUTER,COMPUTER);
			if (playerDouble && !computerDouble) {
				System.out.print("Damn! I win on a Double! Ah! I pity you fool!\nWanna try again? ");
			}
			else if (computerDouble && !playerDouble) {
				System.out.print("Damn! You win on a Double! What Luck!\nDid you cheat?? Gimme another try, c'mon ");
			}
			else {
				System.out.print("Stalemate! You're tough, let's try for a tie-breaker ");
			}
					
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);	
		
		System.out.print(MESSAGE);		
		
		if (!getInput(scan)) {
			System.out.println("See ya later alligator!");
		}
		else {
			System.out.println("Rolling the dice!!");
			rollMessage(PLAYER);
			rollMessage(COMPUTER);
			scoreMessage();
			System.out.println(PROMPT);
			while (getInput(scan)) {				
				System.out.println("Rolling the dice!!");
				rollMessage(PLAYER);
				rollMessage(COMPUTER);
				scoreMessage();
				System.out.println(PROMPT);
			}
			System.out.println("Thanks for being a sport! laters!");
		}
		
		
		System.out.println("end");
		scan.close();
	}

}
