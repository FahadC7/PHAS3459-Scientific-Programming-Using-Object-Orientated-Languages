package module5;

import java.io.*;
import java.net.*;
import java.util.*;

public class DataAnalysis {

	//method that reads data from URL and returns them as an ArrayList object
	public static ArrayList<DataPoint> dataFromURL(String url) throws IOException{
		//reading data from URL and generating a BufferedReader object
		URL u = new URL(url); 
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		Scanner s = new Scanner(br); //BufferedReader Scanner
		DataPoint p; //create DataPoint object
		ArrayList<DataPoint> data = new ArrayList<DataPoint>(); //create ArrayList object

		//loops over data and assigns y, x and ey values to Datapoint object
		//then adds DataPoint object to ArrayList
		while(s.hasNext()) {
			p = new DataPoint(s.nextDouble(), s.nextDouble(), s.nextDouble());
			data.add(p);
		}
		s.close(); //close scanner stream
		return data; //returns ArrayList
	}

	//chi-squared test for data
	public static double goodnessOfFit(Theory tData, ArrayList<DataPoint> mData) {
		double chiSqr = 0; //initialise chi squared value as 0
		
		//for loop that sums individual chi-squareds to give final chi-square value
		for (int i=0; i<mData.size(); i++) {
			double yMeasured = mData.get(i).yGet();
			double yTheory = tData.y(mData.get(i).xGet());
			double yError = mData.get(i).eyGet();
			chiSqr = chiSqr + Math.pow(((yMeasured - yTheory) / yError),2);
		}
		return chiSqr; //returns chi-squared value
	}

	public static void main(String[] args) {
		//try-block for exception handling
		try{
			//creates ArrayList object from data in URL
			ArrayList<DataPoint> data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
			
			Theory line1 = new Theory(2); //y = x^2 Theory object
			Theory line2 = new Theory(4); //y = x^4 Theory object
			
			//determines chi-squareds for both Theory objects and data
			double fit1 = goodnessOfFit(line1, data);
			double fit2 = goodnessOfFit(line2, data);
			
			System.out.println("chi-squared for y = x^2: " +fit1);
			System.out.println("chi-squared for y = x^4: " +fit2);
			System.out.println("y = x^4 is a better fit");
		}
		catch(Exception e) {System.out.println(e);}
	}
}