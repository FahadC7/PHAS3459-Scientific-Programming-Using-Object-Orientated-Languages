package module4;

import java.io.*;
import java.net.*;
import java.util.*;

public class NumericalReader {

	//initialise variables
	private double minValue; //minimum double value in source
	private double maxValue; //maximum double value in source
	private double nValues; //number of doubles in source
	private double sumOfValues; //sum of all doubles in source
	private PrintWriter pw;

	//method that returns a string which is input to the keyboard
	public static String getStringFromKeyboard() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Please specify file directory: ");

		String s = null;
		try {s = br.readLine();}
		catch (Exception e) {System.out.println(e);}

		return s;
	}

	//non-static method that takes a URL name string as input and generates a BufferedReader object
	public BufferedReader brFromURL(String urlName) throws Exception {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}

	//method which creates a file and initialises analysis variables
	void analysisStart(String dataFile) {
		File outputfile = new File(dataFile);
		FileWriter fw = null;
		try {
			fw = new FileWriter(outputfile);		
		}
		catch (Exception e) {System.out.println(e);}

		BufferedWriter br = new BufferedWriter(fw);
		pw = new PrintWriter(br);
		minValue = Double.MAX_VALUE; maxValue = Double.MIN_VALUE; nValues = 0; sumOfValues = 0;
	}

	//method which takes a line of text as string and prints all the doubles in the source into a file and to the screen
	//also updates analysis variables: minValue, maxValue, sumOfValues and nValues
	void analyseData(String line) {
		Scanner s = new Scanner(line);
		while (s.hasNextDouble()) {
			double Val = s.nextDouble();
			System.out.println(Val);
			String token = Double.toString(Val);
			pw.println(token);

			nValues++;
			sumOfValues = sumOfValues + Val;
			if (Val < minValue) {minValue = Val;}
			if (Val > maxValue) {maxValue = Val;}
		}
		s.close();
	}

	//prints all the analysis variables to screen and closes printer
	void analysisEnd() {
		System.out.println("minimum value: " +minValue);
		System.out.println("maximum value: " +maxValue);
		System.out.println("average value: " +sumOfValues/nValues);
		System.out.println("total number of values: " +nValues);
		System.out.println(sumOfValues);
		pw.close();
	}

	public static void main(String[] args) {
		//prompts user to enter a save directory for file
		String 	saveDir = NumericalReader.getStringFromKeyboard();

		//if user doesnt enter anything the default system directory is used
		if (saveDir.length() == 0) {
			saveDir = System.getProperty("user.home");
			System.out.println("No keyboard input, default directory used");
		}

		//creates save directory and file name as string
		String saveFile1 = (saveDir + File.separator + "numbers1.txt");	
		NumericalReader nr1 = new NumericalReader();

		//try catch block for analysing first data URL
		try {
			BufferedReader br = nr1.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
			String line = "";

			nr1.analysisStart(saveFile1); // initialise minValue etc.
			while ((line = br.readLine()) != null) {
				nr1.analyseData(line); // analyse lines, check for comments etc.
			}

			nr1.analysisEnd(); // print min, max, etc.
		}
		catch (Exception e) {}

		//creates save directory and file name as string
		String saveFile2 = (saveDir + File.separator + "numbers2.txt");			
		NumericalReader nr2 = new NumericalReader();

		//try catch block for analysing first data URL
		try {
			BufferedReader br = nr2.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
			String line = "";

			nr2.analysisStart(saveFile2); // initialise minValue etc.
			while ((line = br.readLine()) != null) {
				nr2.analyseData(line); // analyse lines, check for comments etc.
			}

			nr2.analysisEnd(); // print min, max, etc.
		}
		catch (Exception e) {}
	}
}
