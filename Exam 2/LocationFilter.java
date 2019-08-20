package exam2;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * filters flights according to origin and destination location
 */
public class LocationFilter implements FlightFilter{

	/**
	 * origin and destination airports
	 */
	String origin;
	String destination;
	
	/**
	 * constructor
	 */
	public LocationFilter(String origin, String destination) {
		this.origin = origin; this.destination = destination;
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
			if(flight.getValue().depAirport.equals(this.origin) && flight.getValue().destAirport.equals(this.destination)) {
				outMap.put(flight.getKey(), flight.getValue());
			}
		}
		return outMap;
	}

}
