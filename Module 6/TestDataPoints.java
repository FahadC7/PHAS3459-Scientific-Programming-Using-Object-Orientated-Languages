package module6;

import java.io.*;
import java.net.URL;
import java.util.*;

public class TestDataPoints {

	//method that reads data from URL and returns them as an ArrayList object
	public static ArrayList<DataPoint> dataFromURL(String url) throws IOException{
		//reading data from URL and generating a BufferedReader object
		URL u = new URL(url); 
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		DataPoint dp; //create DataPoint object
		LabelledDataPoint ldp; //create LabelledDataPoint object
		ArrayList<DataPoint> data = new ArrayList<DataPoint>(); //create ArrayList object

		//loops over data and assigns y, x and ey values to DataPoint or LabelledDataPoint object
		//then adds DataPoint object to ArrayList
		String line;
		while((line = br.readLine()) != null) {
			Scanner s = new Scanner(line); //BufferedReader Scanner
			StringTokenizer st = new StringTokenizer(line);
			while(s.hasNext()) {

				//if the line of data has 3 tokens then DataPoint type is used
				if(st.countTokens() == 3) {
					dp = new DataPoint(s.nextDouble(), s.nextDouble(), s.nextDouble());
					data.add(dp);
				}

				//if the line of data has 4 tokens then LabelledDataPoint type is used
				if(st.countTokens() == 4) {
					ldp = new LabelledDataPoint(s.nextDouble(), s.nextDouble(), s.nextDouble(), s.next());
					data.add(ldp);
				}
			}
			s.close(); //close scanner stream
		}

		return data; //returns ArrayList
	}

	public static void main(String[] args) {
		try {
			//creates ArrayList of data from URL using dataFromURL method
			ArrayList<DataPoint> data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");

			//loops over all data in ArrayList and prints
			for(DataPoint point : data) {
				System.out.println(point);
			}
		}
		catch(Exception e) {System.out.println(e);}
	}

}
