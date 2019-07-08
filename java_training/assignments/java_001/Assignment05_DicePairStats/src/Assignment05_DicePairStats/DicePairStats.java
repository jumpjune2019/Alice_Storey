/**
 * 
 */
package Assignment05_DicePairStats;

import java.util.Arrays;

class OutputLine implements Comparable {
	private String line;
	
	public OutputLine(String line) {
		this.line = line;
	}
	
	public String getLine() {
		return this.line;
	}
	
	@Override
	public int compareTo(Object o) {

		String lineA = this.line,
				lineB = ((OutputLine) o).getLine();
		
		int countA = Integer.parseInt(lineA.substring(lineA.lastIndexOf(":")+2,  lineA.lastIndexOf(" ")  )   );
		int countB = Integer.parseInt(lineB.substring(lineB.lastIndexOf(":")+2,  lineB.lastIndexOf(" ")  )   );
		
		return countB - countA;
	}
};

/**
 * @author alice
 *
 */
public class DicePairStats {
	
	
	
	private static int roll1d6() {
		int result = 0;
		double ran = Math.random();
		result = (int)(6*ran);
		result++;
		return result;
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String TITLE="1000 Random 2 dice toss stats";
		System.out.println(TITLE);		
		
		int[][] tally = new int[6][6];
		OutputLine[] finalTally = new OutputLine[21];
		
		for (int i=0; i<1000; i++) {
			int rollA = roll1d6();
			int rollB = roll1d6();
			if (rollA >= rollB) {
				tally[rollA-1][rollB-1] ++;
			}
			else {
				tally[rollB-1][rollA-1] ++;
			}
		}
		
		int finalTallyCount = 0;
		for (int i=6; i>=1; i--) {
			for (int j=i; j>=1; j--) {
				finalTally[finalTallyCount] = new OutputLine( String.format("Dice %d and %d: %d times", i, j, tally[i-1][j-1]) );
				finalTallyCount++;
			}
		}
		Arrays.sort(finalTally);
		
		for (int i=0; i<finalTally.length; i++) {
			System.out.println(finalTally[i].getLine());
		}
		
	}

}
