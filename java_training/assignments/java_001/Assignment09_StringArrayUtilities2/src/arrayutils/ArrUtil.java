package arrayutils;

import java.util.Arrays;

public class ArrUtil {
	
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

}
