package trafficlight;
import java.util.Scanner;
import trafficlight.TrafficLight;

/**
 * @author Alice
 * @version 1.0
 * @since 2019-07-12
 */
public class TrafficLightApp {

	private static void takeInput() {
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		TrafficLight trafficLight = new TrafficLight("Light");		
		
		takeInput();
		trafficLight.mystop();
	}

}
