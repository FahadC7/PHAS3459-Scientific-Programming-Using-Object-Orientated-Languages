package module5;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Map.Entry;

public class Minerals {
	//method that creates HashMap for mineral code as key and mass as value
	public static HashMap<Integer,Double> massHashMap(String url) throws IOException {
		//creates BufferedReader from URL data
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		Scanner s = new Scanner(br); //scanner object
		HashMap<Integer,Double> map = new HashMap<Integer, Double>(); //creates HashMap
		Integer code; //creates mineral code as Integer object
		Double mass; //creates mineral mass as Double object
		
		//reads scanner to assign code and mass values to HashMap
		while(s.hasNext()) {
			code = s.nextInt();
			mass = s.nextDouble();
			map.put(code, mass);
		}
		
		s.close(); //closes scanner
		return map; //returns HashMap<code,mass>
	}

	//method that creates HashMap for mineral code as key and location as value
	public static HashMap<Integer,String> locationHashMap(String url) throws IOException {
		//creates BufferedReader from URL data
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		Scanner s = new Scanner(br); //scanner object
		HashMap<Integer,String> map = new HashMap<Integer,String>(); //creates HashMap
		String location; //creates location as String object
		Integer code; //creates code as Integer object
		
		//reads scanner to assign location and code values to HashMap
		while(s.hasNext()) {
			location = s.next();
			code = s.nextInt();
			map.put(code, location);
		}
		
		s.close(); //closes scanner
		return map; //returns HashMap<code,location>
	}

	public static void main(String[] args) {
		try {
			//creates HashMap<code,mass> and HashMap<code,location> objects from URLs
			HashMap<Integer,Double> massMap = Minerals.massHashMap("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");
			HashMap<Integer,String> locationMap = Minerals.locationHashMap("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");

			//converts mass HashMap to Collection to find min and max mass values
			Collection<Double> massValues = massMap.values();
			double minMass = Collections.min(massValues);
			double maxMass = Collections.max(massValues);

			//loops over mass HashMap to match min and max mass values with corresponding keys
			for (Entry<Integer, Double> entry : massMap.entrySet()) {
				//finds corresponding key for min mass value
				if (entry.getValue().equals(minMass)) {
					System.out.println("Minerals with smallest mass:");
					System.out.println("code:"+entry.getKey()+", mass:"+massMap.get(entry.getKey())+"g, location:"+locationMap.get(entry.getKey()));
				}
				
				//finds corresponding key for max mass value
				if (entry.getValue().equals(maxMass)) {
					System.out.println("Minerals with largest mass:");
					System.out.println("code:"+entry.getKey()+", mass:"+massMap.get(entry.getKey())+"g, location:"+locationMap.get(entry.getKey()));
				}				
			}
		}
		catch (Exception e) {System.out.println(e);}
	}
}
