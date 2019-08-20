package exam2;

/**
 * Airports object which stores details of the airport code, full name and time zone with a toString method for clearer representation of the object when printing
 */
public class Airports {
	String airportCode; /** 3 letter airport code */
	String name; /** full airport name */
	String timeZone; /** airport time zone */

	/**
	 *  constructor
	 */
	public Airports(String airportCode, String name, String timeZone) {
		this.airportCode = airportCode;
		this.name = name;
		this.timeZone = timeZone;
	}

	public Airports() {}

	public String toString() {
		return "code: " +this.airportCode +", full-name: " +this.name +", time-zone: " +this.timeZone;
	}

}
