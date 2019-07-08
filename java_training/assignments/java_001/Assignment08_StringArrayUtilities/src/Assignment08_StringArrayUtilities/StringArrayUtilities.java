/**
 * 
 */
package Assignment08_StringArrayUtilities;

import java.util.Arrays;

/**
 * @author alice
 *
 */
public class StringArrayUtilities {

	public static boolean arrayHasExactMatch(String[] array, String search, boolean caseSensitive) {
		boolean found = false;
		
		for (String item : array) {
			if (caseSensitive) {
				if (item.equals(search)) {
					found = true;
					break;
				}
			}
			else {
				if (item.equalsIgnoreCase(search)) {
					found = true;
					break;
				}
			}
		}
		
		return found;
	}
	
	public static int[] indexOfOccuranceInArray(String[] array, String search, boolean caseSensitive) {
		int indices[] = {-1};
		
		for (int i=0; i<array.length; i++) {
			if (caseSensitive) {
				if (array[i].equals(search)) {
					int[] index = {i};
					indices = concatArrays(indices, index);
				}
			}
			else {
				if (array[i].equalsIgnoreCase(search)) {
					int[] index = {i};
					indices = concatArrays(indices, index);
				}
			}
		}
		
		//remove -1 if other index is found
		if (indices.length > 1) {
			indices = Arrays.copyOfRange(indices, 1, indices.length);
		}
		
		return indices;
	}
	
	private static int[] concatArrays(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		
		int counter = 0;
		for (int item : a) {
			result[counter] = item;
			counter++;
		}
		for (int item : b) {
			result[counter] = item;
			counter++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String myList[] = { "Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo" };
		
		System.out.printf("This is a test of the arrayHasExactMatch and indexOfOccurenceInArray methods\nThe array to test contains the following items\n{ \"Bozo\", \"FooBar\", \"Delta\", \"Foozball\", \"Demo\", \"Money\", \"Zoo\" }\n");
		
		System.out.printf("Scenario 1\nArrUtil.arrayHasExactMatch (myList, \"zo\", false): is %b\n", arrayHasExactMatch (myList, "zo", false));
		System.out.printf("Scenario 2\nArrUtil.arrayHasExactMatch (myList, \"zoo\", false): is %b\n", arrayHasExactMatch (myList, "zoo", false));
		System.out.printf("Scenario 3\nArrUtil.arrayHasExactMatch (myList, \"zoo\", true): is %b\n", arrayHasExactMatch (myList, "zoo", true));
		System.out.printf("Scenario 4\nArrUtil.arrayHasExactMatch (myList, \"foo\", true): is %b\n", arrayHasExactMatch (myList, "foo", true));
		System.out.printf("Scenario 5\nArrUtil.arrayHasExactMatch (myList, \"foo\", false): is %b\n", arrayHasExactMatch (myList, "foo", false));
		System.out.printf("Scenario 6\nArrUtil.arrayHasExactMatch (myList, \"delta\", true): is %b\n", arrayHasExactMatch (myList, "delta", true));
		System.out.printf("Scenario 7\nArrUtil.arrayHasExactMatch (myList, \"Delta\", true): is %b\n", arrayHasExactMatch (myList, "Delta", true));
		
		System.out.printf("Scenario 8\nArrUtil.indexOfOccuranceInArray (myList, \"zo\", false) returns %s\n", Arrays.toString(indexOfOccuranceInArray (myList, "zo", false)));
		System.out.printf("Scenario 9\nArrUtil.indexOfOccuranceInArray (myList, \"zoo\", false) returns %s\n", Arrays.toString(indexOfOccuranceInArray (myList, "zoo", false)));
		System.out.printf("Scenario 10\nArrUtil.indexOfOccuranceInArray (myList, \"zoo\", true) returns %s\n", Arrays.toString(indexOfOccuranceInArray (myList, "zoo", true)));
		System.out.printf("Scenario 11\nArrUtil.indexOfOccuranceInArray (myList, \"foo\", true) returns %s\n", Arrays.toString(indexOfOccuranceInArray (myList, "foo", true)));
		System.out.printf("Scenario 12\nArrUtil.indexOfOccuranceInArray (myList, \"foo\", false) returns %s\n", Arrays.toString(indexOfOccuranceInArray (myList, "foo", false)));
		System.out.printf("Scenario 13\nArrUtil.indexOfOccuranceInArray (myList, \"delta\", true) returns %s\n", Arrays.toString(indexOfOccuranceInArray (myList, "delta", true)));
		System.out.printf("Scenario 14\nArrUtil.indexOfOccuranceInArray (myList, \"Delta\", true) returns %s\n", Arrays.toString(indexOfOccuranceInArray (myList, "Delta", true)));
	}

}
