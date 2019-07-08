package app;
import java.util.Arrays;

import arrayutils.ArrUtil;

public class MainApp {

	public static void main(String[] args) {
		String myList[] = { "Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo" };
		
		System.out.printf("This is a test of the arrayHasExactMatch and indexOfOccurenceInArray methods\nThe array to test contains the following items\n{ \"Bozo\", \"FooBar\", \"Delta\", \"Foozball\", \"Demo\", \"Money\", \"Zoo\" }\n");
		
		System.out.printf("Scenario 1\nArrUtil.arrayHasExactMatch (myList, \"zo\", false): is %b\n", ArrUtil.arrayHasExactMatch (myList, "zo", false));
		System.out.printf("Scenario 2\nArrUtil.arrayHasExactMatch (myList, \"zoo\", false): is %b\n", ArrUtil.arrayHasExactMatch (myList, "zoo", false));
		System.out.printf("Scenario 3\nArrUtil.arrayHasExactMatch (myList, \"zoo\", true): is %b\n", ArrUtil.arrayHasExactMatch (myList, "zoo", true));
		System.out.printf("Scenario 4\nArrUtil.arrayHasExactMatch (myList, \"foo\", true): is %b\n", ArrUtil.arrayHasExactMatch (myList, "foo", true));
		System.out.printf("Scenario 5\nArrUtil.arrayHasExactMatch (myList, \"foo\", false): is %b\n", ArrUtil.arrayHasExactMatch (myList, "foo", false));
		System.out.printf("Scenario 6\nArrUtil.arrayHasExactMatch (myList, \"delta\", true): is %b\n", ArrUtil.arrayHasExactMatch (myList, "delta", true));
		System.out.printf("Scenario 7\nArrUtil.arrayHasExactMatch (myList, \"Delta\", true): is %b\n", ArrUtil.arrayHasExactMatch (myList, "Delta", true));
		
		System.out.printf("Scenario 8\nArrUtil.indexOfOccuranceInArray (myList, \"zo\", false) returns %s\n", Arrays.toString(ArrUtil.indexOfOccuranceInArray (myList, "zo", false)));
		System.out.printf("Scenario 9\nArrUtil.indexOfOccuranceInArray (myList, \"zoo\", false) returns %s\n", Arrays.toString(ArrUtil.indexOfOccuranceInArray (myList, "zoo", false)));
		System.out.printf("Scenario 10\nArrUtil.indexOfOccuranceInArray (myList, \"zoo\", true) returns %s\n", Arrays.toString(ArrUtil.indexOfOccuranceInArray (myList, "zoo", true)));
		System.out.printf("Scenario 11\nArrUtil.indexOfOccuranceInArray (myList, \"foo\", true) returns %s\n", Arrays.toString(ArrUtil.indexOfOccuranceInArray (myList, "foo", true)));
		System.out.printf("Scenario 12\nArrUtil.indexOfOccuranceInArray (myList, \"foo\", false) returns %s\n", Arrays.toString(ArrUtil.indexOfOccuranceInArray (myList, "foo", false)));
		System.out.printf("Scenario 13\nArrUtil.indexOfOccuranceInArray (myList, \"delta\", true) returns %s\n", Arrays.toString(ArrUtil.indexOfOccuranceInArray (myList, "delta", true)));
		System.out.printf("Scenario 14\nArrUtil.indexOfOccuranceInArray (myList, \"Delta\", true) returns %s\n", Arrays.toString(ArrUtil.indexOfOccuranceInArray (myList, "Delta", true)));
	}

}
