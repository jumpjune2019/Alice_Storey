import java.util.Arrays;


interface Sort<T extends Comparable<T>>  {
	int sortf(T a, T b);
	default void handle(T[] array) {
		Arrays.sort(array, (a, b) ->
			sortf(a,b)  );
	}
}
