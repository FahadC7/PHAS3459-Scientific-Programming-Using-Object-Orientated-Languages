package exam2;

/**
 * Flights object which stores details of the flights with a toString method for clearer representation of the object when printing
 */
public class Flights {
	String ID; /** flight code */
	String depAirport; /** departure airport */
	String destAirport; /** destination airport */
	String depDate; /** departure date */
	String depTime; /** departure time */
	String destDate; /** arrival date */
	String destTime; /** arrival time */
	double cost; /** cost of fligh in pounds */
	
	public Flights(String ID, String dpA, String dsA, String dpD, String dpT, String dsD, String dsT, double cost) {
		this.ID = ID;
		this.depAirport = dpA;
		this.destAirport = dsA;
		this.depDate = dpD;
		this.depTime = dpT;
		this.destDate = dsD;
		this.destTime = dsT;
		this.cost = cost;
	}
	
	public Flights() {}
	
	public String toString() {
		return "ID: " +this.ID +", from: " +this.depAirport +" to:" +this.destAirport +", departure: [" +this.depTime +" " +this.depDate +"], arrival: [" +this.destTime +" " +this.destDate +"] cost = £" +this.cost;
	}

}
