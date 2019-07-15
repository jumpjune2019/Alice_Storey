package coins;
import coins.CountMoney;
import coins.Money;
import static coins.Money.Denomination;



public class CoinsApp {
	

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Money money = new Money();				
		CountMoney cm = new CountMoney();
		cm.setMoney(money);
		
		System.out.println(cm.returnRaw());
		System.out.println(cm.returnPretty());
		System.out.println(cm.returnCurrency());
		
		money.setPenny(1);
		money.setQuarter(2);
		money.setDollar(3);
		
		System.out.println(cm.returnRaw());
		System.out.println(cm.returnPretty());
		System.out.println(cm.returnCurrency());
	}

}
