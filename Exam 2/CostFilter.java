package exam2;

import java.util.HashMap;
import java.util.Map.Entry;


/**
 * implementation of FlightFilter that filters for flights with a max cost
 */
public class CostFilter implements FlightFilter{
	/**
	 * max cost
	 */
	double maxCost;	
	
	
	/**
	 * constructor
	 */
	public CostFilter(double cost) {
		this.maxCost = cost;
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
			if(flight.getValue().cost <= this.maxCost) {
				outMap.put(flight.getKey(), flight.getValue());
			}
		}
		return outMap;
	}

}
