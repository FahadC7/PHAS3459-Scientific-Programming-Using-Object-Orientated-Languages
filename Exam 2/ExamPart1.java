package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class ExamPart1 {
	static HashMap<String,Flights> flights;
	static HashMap<String,Airports> airports;

	/**
	 * makes a BufferedReader object from a URL address
	 */
	public static BufferedReader brFromURL(String url) throws IOException {

		/**
		 * creates URL object
		 * opens stream
		 * creates a stream reader
		 * creates a BufferedReader from input stream reader
		 */
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}

	/**
	 * creates a hashMap of all flights from @br with the flight code as the key and Flight object as value
	 */
	public static HashMap<String,Flights> flightsMap (BufferedReader br){
		HashMap<String,Flights> map = new HashMap<String,Flights>();
		Scanner s = new Scanner(br);

		while(s.hasNextLine()) {
			String[] line  = s.nextLine().split(",");
			Flights flight = new Flights(line[0].trim(), line[1].trim(), line[2].trim(), line[3].trim(), line[4].trim(), line[5].trim(), line[6].trim(), Double.parseDouble(line[7]));
			map.put(flight.ID, flight);
		}

		s.close();
		return map;
	}

	/**
	 * creates a HashMap of airports from @br withy 3 letter airport name as key and airport object as value
	 */
	public static HashMap<String,Airports> airportsMap (BufferedReader br){
		HashMap<String,Airports> map = new HashMap<String,Airports>();
		Scanner s = new Scanner(br);

		while(s.hasNextLine()) {
			String[] line  = s.nextLine().split(",");
			Airports airport = new Airports(line[0].trim(), line[1].trim(), line[2].trim());
			map.put(airport.airportCode, airport);
		}

		s.close();
		return map;
	}


	public static void main(String[] args) {

		/**
		 * making BuffreredReader of both URLs and filling HashMap @flights and @airports
		 */
		try {
			BufferedReader brFlights = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/flights.txt");
			flights = flightsMap(brFlights);
			BufferedReader brAirports = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/airports.txt");
			airports = airportsMap(brAirports);

		} 
		catch (Exception e) {e.printStackTrace();}

		/**
		 * printing details of all flights
		 */
		try {
			for(Entry<String,Flights> flight : flights.entrySet()) {
				/**
				 * flight code
				 */
				System.out.println("\nflight code: " +flight.getValue().ID);
				
				/**
				 * departure and arrival times
				 */
				System.out.println("departure: [" +flight.getValue().depTime +" " +flight.getValue().depDate +"] " +airports.get(flight.getValue().depAirport).name);
				System.out.println("arrival: [" +flight.getValue().destTime +" " +flight.getValue().destDate +"] " +airports.get(flight.getValue().destAirport).name);

				/**
				 * duration of flight calculated from duration method
				 */
				long duration = Duration.duration(flight.getValue(), airports);
				System.out.println("duration: " +duration +" minutes");

				/**
				 * cost of flight
				 */
				System.out.println("flight cost: £" +flight.getValue().cost);
			}
		}
		catch (Exception e) {e.printStackTrace();}





	}

}
