
public class BasicSorting {
	
	static <T extends Comparable<T>> void doSort(T[] array, boolean asc) {
		doSort(array, asc, true);
	}
	
	static <T extends Comparable<T>> void doSort(T[] array, boolean asc, boolean caseSensitive) {
		int reverse = asc ? 1 : -1;
		Sort<T> sort = (a, b) -> reverse * a.compareTo(b);
		
		if(array.length > 0 && array[0] instanceof String && ! caseSensitive) {
			sort = (a,b) -> reverse * ((String)a).compareToIgnoreCase((String)b);
		}
		
		sort.handle(array);
	}
	
	static <T> String printArray (T[] array) {
		String out = "{";
		for (T item : array) {
			out += String.format("%s, ", item.toString());
		}
		out = out.substring(0,out.length()-2 ) + "}";
				
		return out;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] numArr = {10,3,4,15,7,9,1,21};
		System.out.println("Initial Integer Array: " + printArray(numArr));
		doSort(numArr, true);
		System.out.println("Sorted ASC: " + printArray(numArr));
		doSort(numArr, false);
		System.out.println("Sorted DESC: " + printArray(numArr));
		System.out.println();
		
		String[] strArr = { "claude", "Phil", "lois", "clark", "Arthur", "Mera", "bruce"};
		System.out.println("Initial String Array: " + printArray(strArr));
		doSort(strArr, true, true);
		System.out.println("Sorted ASC and CASE SENSITIVITY ON: " + printArray(strArr));
		doSort(strArr, true, false);
		System.out.println("Sorted ASC and CASE SENSITIVITY OFF: " + printArray(strArr));
		doSort(strArr, false, true);
		System.out.println("Sorted DESC and CASE SENSITIVITY ON: " + printArray(strArr));
		doSort(strArr, false, false);
		System.out.println("Sorted DESC and CASE SENSITIVITY OFF: " + printArray(strArr));
	}

}
