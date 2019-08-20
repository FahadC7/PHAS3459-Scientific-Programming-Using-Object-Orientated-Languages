package module8;

import java.util.Random;
import java.util.concurrent.Callable;

//calculates a value for pi using MonteCarlo method
public class MonteCarloPiCalculatorTask implements Callable<Double> {
	private final long n_points; //number of points used
	
	//constructor
	public MonteCarloPiCalculatorTask(long nPoints) {this.n_points = nPoints;}
	
	//call method which calculates MonteCarlo pi value
	public Double call() {
		
		Random rand = new Random(); //create Random object used to generate random points
		long n_in = 0; //number of points inside quarter unit circle
		
		//creates random points and sums number of points inside quarter unit circle
		for (long iPoint = 0; iPoint < n_points; ++iPoint) {
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			double r2 = x*x + y*y;
			if (r2 < 1.0) ++n_in;
		}
		
		return 4.0 * n_in / n_points;
	}
}