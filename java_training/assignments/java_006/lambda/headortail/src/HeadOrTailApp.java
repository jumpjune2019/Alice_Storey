
public class HeadOrTailApp {
	interface Flip<T> {
		T run (int num);
	}
	
	static final String INIT = "Welcome to the game of Head or Tail where you will flip your life away!",
			FIRSTPASS = "Press the F key and flip your luck!",
			RESULT = "The coin flip is:",
			PROMPT = "Press the F key to try again, press Q or q to Quit",
			EXIT = "Thank you for playing";
	
		
	static boolean handleInput(char expected, String msg) {
		char input = ' ';
		while (input != expected)
		{
			System.out.println(msg);
			
			input = CharListener.getCh();
			if (input == 'q' || input == 'Q') {
				return false;
			}			
		}
		return true;
	}

	public static void main(String[] args) {
		
		char input = ' ';
		Flip<Integer> coinflip = (num) -> (int)(2*Math.random())+1;
		Flip<String> sideof = (num) -> num==1 ? "Head" : "Tail";
		
		System.out.println(INIT);
		handleInput('f', FIRSTPASS);
		do {
		System.out.printf("%s %s!\n",RESULT,sideof.run(coinflip.run(0)));
		} while (handleInput('f', PROMPT));
		
		System.out.println(EXIT);
	}

}
