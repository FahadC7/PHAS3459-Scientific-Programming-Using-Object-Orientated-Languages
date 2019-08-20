package exam2;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class ExamPart2 {
	static HashMap<String,Flights> flights;
	static HashMap<String,Airports> airports;

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

		
		/**
		 * flights with max cost of £200
		 */
		try {
			CostFilter filter = new CostFilter(200);
			HashMap<String,Flights> filtered = filter.filter(flights);

			System.out.println("\nflights with max cost of £200:");
			for(Entry<String,Flights> flight : filtered.entrySet()) {System.out.println(flight.getValue().ID);}

		}
		catch (Exception e) {e.printStackTrace();}

		
		/**
		 * flight from LHR to ATH quicker than 4 hours
		 */
		try {
			LocationFilter filter1 = new LocationFilter("LHR", "ATH");
			HashMap<String,Flights> filtered1 = filter1.filter(flights);

			DurationFilter filter2 = new DurationFilter(240, airports);
			HashMap<String,Flights> filtered2 = filter2.filter(filtered1);

			System.out.println("\nflights from LHR to ATH with duration lower than 4 Hours:");
			for(Entry<String,Flights> flight : filtered2.entrySet()) {System.out.println(flight.getValue().ID);}

		}
		catch (Exception e) {e.printStackTrace();}

		
		/**
		 * quickest flight from LHR to ATH under £200
		 */
		try {
			/**
			 * filters for flights from LHR to ATH
			 */
			LocationFilter filter1 = new LocationFilter("LHR", "ATH");
			HashMap<String,Flights> filtered1 = filter1.filter(flights);

			/**
			 * filters the above filtered flights for a cost under £200
			 */
			CostFilter filter2 = new CostFilter(200);
			HashMap<String,Flights> filtered2 = filter2.filter(filtered1);

			/**
			 * loops over all filtered flights to find quickest flight
			 */
			Flights quickestFlight = null; 
			long minDur = Long.MAX_VALUE;
			for(Entry<String,Flights> flight : filtered2.entrySet()) {
				long duration = Duration.duration(flight.getValue(), airports);
				if(duration < minDur) {
					minDur = duration;
					quickestFlight = flight.getValue();
				}
			}
			System.out.println("\nquickest flught from LHR to ATH under £200: " +quickestFlight.ID);

		}
		catch (Exception e) {e.printStackTrace();}

	}

}
