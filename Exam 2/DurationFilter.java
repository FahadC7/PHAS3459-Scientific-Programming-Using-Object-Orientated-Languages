package exam2;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * implementation of FlightFilter that filters for a max duration
 */
public class DurationFilter implements FlightFilter{

	/**
	 * max duration
	 */
	long maxDuration;	
	static HashMap<String,Airports> airports;
	
	
	/**
	 * constructor
	 */
	public DurationFilter(long duration, HashMap<String,Airports> airports) {
		this.maxDuration = duration; this.airports = airports;
	}
	
	/**
	 * filter method that adds specified flights to @outMap and returns
	 */
	public HashMap<String, Flights> filter(HashMap<String, Flights> flights) {
		HashMap<String,Flights> outMap = new HashMap<String,Flights>();

		/**
		 * loops over all flights
		 */
		for(Entry<String, Flights> flight : flights.entrySet()) {
			/**
			 * puts filtered fills into @outMap
			 */
			long duration = Duration.duration(flight.getValue(), airports);
			if(duration <= this.maxDuration) {
				outMap.put(flight.getKey(), flight.getValue());
			}
		}
		return outMap;
	}
}
