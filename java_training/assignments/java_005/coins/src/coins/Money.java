package coins;

public class Money {
	public enum Denomination {PENNY,NICKEL,DIME,QUARTER,HALFDOLLAR,DOLLAR}
	private static int[] wallet;
	
	public Money() {
		wallet = new int[Denomination.values().length];
	}
	
	/**
	 * @param amount number of total pennies
	 * @return whether amount was accepted and set
	 */
	public boolean setPenny(int amount) {
		if (amount > 0) {
			wallet[Denomination.PENNY.ordinal()] = amount;
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * @param amount number of total nickels
	 * @return whether amount was accepted and set
	 */
	public boolean setNickel(int amount) {
		if (amount > 0) {
			wallet[Denomination.NICKEL.ordinal()] = amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @param amount number of total dimes
	 * @return whether amount was accepted and set
	 */
	public boolean setDime(int amount) {
		if (amount > 0) {
			wallet[Denomination.DIME.ordinal()] = amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @param amount number of total quarters
	 * @return whether amount was accepted and set
	 */
	public boolean setQuarter(int amount) {
		if (amount > 0) {
			wallet[Denomination.QUARTER.ordinal()] = amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @param amount number of total half-dollars
	 * @return whether amount was accepted and set
	 */
	public boolean setHalfDollar(int amount) {
		if (amount > 0) {
			wallet[Denomination.HALFDOLLAR.ordinal()] = amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @param amount number of total dollar coins
	 * @return whether amount was accepted and set
	 */
	public boolean setDollar(int amount) {
		if (amount > 0) {
			wallet[Denomination.DOLLAR.ordinal()] = amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @return number of stored pennies
	 */
	public int getPenny() {
		return wallet[Denomination.PENNY.ordinal()];
	}
	
	/**
	 * @return number of stored nickels
	 */
	public int getNickel() {
		return wallet[Denomination.NICKEL.ordinal()];
	}
	
	/**
	 * @return number of stored dimes
	 */
	public int getDime() {
		return wallet[Denomination.DIME.ordinal()];
	}
	
	/**
	 * @return number of stored quarters
	 */
	public int getQuarter() {
		return wallet[Denomination.QUARTER.ordinal()];
	}
	
	/**
	 * @return number of stored half-dollars
	 */
	public int getHalfDollar() {
		return wallet[Denomination.HALFDOLLAR.ordinal()];
	}
	
	/**
	 * @return number of stored dollar coins
	 */
	public int getDollar() {
		return wallet[Denomination.DOLLAR.ordinal()];
	}
}
