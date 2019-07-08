/**
 * 
 */
package Assignment02_HeadOrTailTally;

/**
 * @author alice
 *
 */
public class HeadOrTailTally {
	
	private static int randomBinary() {
		int result = -1;
		
		double ran = Math.random();
		result = (int) (2 *ran);
		result ++;
		
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String TITLE="1000 Coin Flips";
		System.out.println(TITLE);		
		
		int[] tally = {0,0};
		for (int i=0; i<1000; i++) {
			int result = randomBinary();
			tally[result-1]++;
		}
		
		System.out.printf("Count of Head: %d\nCount of Tail: %d\n", tally[0], tally[1]);
		
	}

}
