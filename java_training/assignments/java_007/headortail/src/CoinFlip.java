
public class CoinFlip {
	
	interface Flip<T> {
		T run (int num);
	}
	public static final Flip<Integer> coinflip = (num) -> (int)(2*Math.random())+1;
	public static final Flip<String> sideof = (num) -> num==1 ? "Head" : "Tail";
	

}
