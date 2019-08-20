package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable {

	ArrayList<Integer> primeArray = new ArrayList<Integer>(); //array of prime numbers
	int number; //number being checked

	//constructor
	public PrimeNumberTask() {}

	public void run() {	
		number = 2; //start checking integers ascending from 2
		
		//loop which checks number if it is prime
		while (true) { //runs until interrupted
			if(Thread.currentThread().isInterrupted()) {return;} //checks if thread interrupted
			
			//sets isPrime boolean to true initially and if the checked integer number 
			//is not prime the isPrime is set to false
			boolean isPrime = true; 
			for(int i = 2; i < number; i++) {
				if(number % i == 0) {isPrime = false;}
			}
			
			//if isPrime remained true in for loop, it is added to primeArray
			if(isPrime == true) {primeArray.add(number);}
			number++;
		}
	}

}
