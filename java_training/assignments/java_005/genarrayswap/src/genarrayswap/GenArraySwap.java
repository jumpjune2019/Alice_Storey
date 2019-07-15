package genarrayswap;

/**
 * @author Alice
 * @version 1.0
 * @since 2019-07-12
 */
public class GenArraySwap {
	
	/**
	 * @param <Type>
	 * @param array This is an array, of any type, on which to perform an element swap.
	 * @param firstelement Index for the first element to be swapped.
	 * @param secondelement Index for the second element to be swapped.
	 * @return Returns whether the swap operation is completed. This relies on both indices being in bounds of the given array.
	 */
	public static <Type> boolean swap(Type[] array, int firstelement, int secondelement) {
		if (firstelement < array.length && secondelement < array.length) {
			Type o = array[firstelement];
			array[firstelement] = array[secondelement];
			array[secondelement] = o;
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String[] array = {"apples", "oranges"};
		Integer[] arraynums = {1,2};
		
		System.out.printf("%s, %s\n",array[0], array[1]);
		swap(array,0,1);
		System.out.printf("%s, %s\n",array[0], array[1]);
		swap(arraynums,0,1);
	}

}
