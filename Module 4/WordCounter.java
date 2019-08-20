package module4;

import java.io.*;
import java.net.*;
import java.util.*;

public class WordCounter {

	//method that takes a URL in string form as input and generates a BufferedReader object
	public static BufferedReader brFromURL(String urlName) throws Exception {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}

	//method that takes a file name as input in string form and generates a BufferedReader object
	public static BufferedReader brFromFile(String fileName) throws Exception {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		fr.close();
		return br;
	}

	//method that that takes BufferedReader as input and counts the number of words in the source
	public static int countWordsInResource(BufferedReader dataAsBR) throws Exception{
		BufferedReader br = new BufferedReader(dataAsBR);
		Scanner s = new Scanner(br);
		int i = 0;
		while (s.hasNext()) {
			String token = s.next();
			try {
				i++;
			} 
			catch (Exception e) {
				System.out.println(e);
			}
		}
		s.close();
		return i;
	}



	public static void main(String[] args) {
		//try-catch block that uses a URL as a source and counts the words in it
		try{
			BufferedReader br = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
			System.out.println("word count: " +countWordsInResource(br));
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
