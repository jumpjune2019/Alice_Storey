/**
 * 
 */
package Assignment01_HeadOrTail;

/**
 * @author alice
 *
 */
public class HeadOrTail {
	
	private static int randomBinary() {
		int result = -1;
		
		double ran = Math.random();
		result = (int) (2 *ran);
		result ++;
		
		return result;
	}
	
	private static String headOrTail(int roll) {
		String result = "";
		if (roll == 1) {
			result = "Head";
		}
		else if (roll == 2) {
			result = "Tail";
		}
		
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String TITLE="Coin Flip Program";
		System.out.println(TITLE);
		
		System.out.printf("The Coin Flip is: %s\n",headOrTail(randomBinary()));
	}

}
