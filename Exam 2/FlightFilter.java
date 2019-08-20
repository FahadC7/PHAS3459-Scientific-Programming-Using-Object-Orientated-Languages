package exam2;

import java.util.HashMap;

/**
 * interface for filtering flights
 */
public interface FlightFilter {
	
	/**
	 * takes HashMap of flights and returns HashMap of flights
	 */
	public HashMap<String,Flights> filter(HashMap<String,Flights> flights);

}
