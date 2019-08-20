package module8;

import java.util.Collections;

public class ThreadsMain {

	public static void main(String[] args) {
		
		PrimeNumberTask pmt = new PrimeNumberTask();
		Thread countdown = new Thread(new CountdownTask(10));
		Thread prime = new Thread(pmt);

		countdown.start();
		prime.start();

		try {
			countdown.join();
		}
		catch(Exception e) {System.out.println(e);}
		prime.interrupt();
		
		System.out.println("largest integer checked: " +pmt.number);
		System.out.println("largest prime found: " +Collections.max(pmt.primeArray));
		System.out.println("number of primes found: " +pmt.primeArray.size());

	}

}
