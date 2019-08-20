package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsTimer {

	public static void main(String[] args) {
		long nPoints = 10000000; //number of points used in MonteCarlo pi calculation

		//initialise start and end time stamps for calculations
		double startTime;
		double endTime;

		MonteCarloPiCalculatorTask task1 = new MonteCarloPiCalculatorTask(nPoints);

		startTime = System.currentTimeMillis(); //start time of calculation
		double pi1 = task1.call(); //calculates pi estimate
		endTime = System.currentTimeMillis(); //end time of calculation

		System.out.println("1 thread");
		System.out.println("pi: " +pi1);
		double calcTime1 = endTime - startTime;
		System.out.println("run time: " +calcTime1+ "ms \n");

		//4 threads created and submitted to thread pool
		int nThreads = 4;
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			MonteCarloPiCalculatorTask task2 = new
					MonteCarloPiCalculatorTask(nPoints/nThreads);
			Future<Double> future = threadPool.submit(task2);
			futures.add(future);
		}

		double sum = 0.0; //initialise sum of pi's

		startTime = System.currentTimeMillis(); //calculation start time
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			double result = 0;
			try {result = futures.get(iThread).get();} 
			catch (Exception e) {e.printStackTrace();} 
			sum += result;
		}
		endTime = System.currentTimeMillis(); //calculation end time

		threadPool.shutdown(); //close pool

		double pi2 = sum/nThreads;
		System.out.println("4 threads");
		System.out.println("pi: " +pi2);

		double calcTime2 = endTime - startTime;
		System.out.println("run time: " +calcTime2+ "ms \n");

		System.out.println("Using 4 threads compared to 1 thread is significantly faster at calculating"
				+ " the pi value.");
	}
}
