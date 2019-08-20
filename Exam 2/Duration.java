package exam2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

/**
 * method for calculating duration of a flight in minutes
 */
public class Duration {
	
	/**
	 * constructor
	 */
	public Duration() {}
	
	/**
	 * calculates flight time in minutes
	 * @flight flight to be used in calculation 
	 * @airports airports for indexing full airport name and time zone
	 * @return duration
	 */
	public static long duration(Flights flight, HashMap<String,Airports> airports) {
		String timeZoneDep = airports.get(flight.depAirport).timeZone;
		String timeZoneArr = airports.get(flight.destAirport).timeZone;
		
		/**
		 * find local date and time
		 * then finds zone ID
		 * then using both these parameters finds the zoned time
		 */
		LocalDateTime lt1 = LocalDateTime.parse(flight.depDate +"T" +flight.depTime);
		ZoneId z1 = ZoneId.of(timeZoneDep);
		ZonedDateTime zt1 = ZonedDateTime.of(lt1, z1);
		
		LocalDateTime lt2 = LocalDateTime.parse(flight.destDate +"T" +flight.destTime);
		ZoneId z2 = ZoneId.of(timeZoneArr);
		ZonedDateTime zt2 = ZonedDateTime.of(lt2, z2);
		
		/**
		 * duration between zoned times
		 */
		long duration = zt1.until(zt2, ChronoUnit.MINUTES);
		
		return duration;

	}

}
