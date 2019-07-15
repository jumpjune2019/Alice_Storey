package coins;
import coins.Money;
import static coins.Money.Denomination;

public class CountMoney {
	private Money money;
	
	public void setMoney(Money money) {
		this.money = money;
	}
	
	public double returnRaw() {
		double sum = .01*money.getPenny() + .05*money.getNickel() + .1*money.getDime() + .25*money.getQuarter() + .5*money.getHalfDollar() + money.getDollar();
		return sum;
	}
	
	public String returnPretty() {
		double sum = returnRaw();
		
		double dollars =  Math.floor(sum);
		double cents = sum - dollars;
		
		return String.format("%.0f dollars and %.0f cents", dollars, cents*100);
	}
	
	public String returnCurrency() {
		double sum = returnRaw();
		
		return String.format("$%.2f", sum);
	}
}
