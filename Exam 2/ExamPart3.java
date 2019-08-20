package exam2;

import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * finding cheapest flight route from @depAirport to @destAirport under a specified duration including stop over flights
 */
public class ExamPart3 {
	static HashMap<String,Flights> flights;
	static HashMap<String,Airports> airports;

	/**
	 * departure and destination airports with max duration of route in minutes
	 */
	static String depAirport;
	static String destAirport;
	static long maxDuration;

	public static void main(String[] args) {
		/**
		 * making BuffreredReader of both URLs and filling HashMap @flights and @airports
		 */
		try {
			BufferedReader brFlights = ExamPart1.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/flights.txt");
			flights = ExamPart1.flightsMap(brFlights);
			BufferedReader brAirports = ExamPart1.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/airports.txt");
			airports = ExamPart1.airportsMap(brAirports);

		} 
		catch (Exception e) {e.printStackTrace();}

		try {
			/**
			 * setting departure and arrival airport
			 */
			depAirport = "LHR";
			destAirport = "CPT";
			maxDuration = 24*60;

			HashMap<String,Flights> firstFlights = new HashMap<String,Flights>();
			HashMap<String,Flights> secondFlights = new HashMap<String,Flights>();

			ArrayList<ArrayList<String>> stopOverFlights = new ArrayList<ArrayList<String>>();

			LocationFilter filter = new LocationFilter(depAirport, destAirport);
			HashMap<String,Flights> directFlights = filter.filter(flights);


			for(Entry<String, Flights> flight : flights.entrySet()) {
				/**
				 * finds all flights leaving from @depAirport
				 */
				if(flight.getValue().depAirport.equals(depAirport)) {firstFlights.put(flight.getKey(), flight.getValue());}

				/**
				 * finds all flights arriving at @destAirport
				 */
				if(flight.getValue().destAirport.equals(destAirport)) {secondFlights.put(flight.getKey(), flight.getValue());}
			}

			for(Entry<String,Flights> firstFlight : firstFlights.entrySet()) {
				/**
				 * arrival time for 1st flight
				 */
				LocalDateTime lt1 = LocalDateTime.parse(firstFlight.getValue().destDate +"T" +firstFlight.getValue().destTime);

				for(Entry<String,Flights> secondFlight : secondFlights.entrySet()) {
					/**
					 * departure time for 2nd flight
					 */
					LocalDateTime lt2 = LocalDateTime.parse(secondFlight.getValue().depDate +"T" +secondFlight.getValue().depTime);

					if(lt2.isAfter(lt1)) {
						long totalDuration = Duration.duration(firstFlight.getValue(), airports) + Duration.duration(secondFlight.getValue(), airports);
						if(totalDuration < maxDuration) {
							ArrayList<String> stopOverFlight = new ArrayList<String>();
							stopOverFlight.add(firstFlight.getKey());
							stopOverFlight.add(secondFlight.getKey());
							stopOverFlight.add(String.valueOf(totalDuration));

							stopOverFlights.add(stopOverFlight);
						}
					}

				}
			}

			System.out.println(stopOverFlights);

			Flights cheapestDirectFlight = null; 
			long minCost = Long.MAX_VALUE;
			for(Entry<String,Flights> flight : directFlights.entrySet()) {
				double cost = flight.getValue().cost;
				if(cost < minCost) {
					minCost = (long) cost;
					cheapestDirectFlight = flight.getValue();
				}
			}
			System.out.println("\nquickest flught from LHR to ATH under £200: " +cheapestDirectFlight.ID);
			
			//ran out of time to find cheapest non direct flight

		}
		catch (Exception e) {e.printStackTrace();}

	}

}
