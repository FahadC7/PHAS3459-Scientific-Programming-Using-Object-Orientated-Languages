//Fahad Chohan Module 1
package module1;

public class AlgorithmControl {

	//defining a function which prints numbers starting at an integer 's'
	//and ending at an integer 'f' while going up in increments of 1.
	public void loop(int s, int f) {
		for (int n = s; n <= f; n++) {
			System.out.println("n = "+n);
		}
	}
	
	//defining a function which prints numbers going down from
	//integer 's' to 'f' in increments of 1
	public void decrement(int s, int f) {
		int n = s;
		while(n >= f) {
			System.out.println("n = " +n);
			n--;
		}
	}
	
	//defining a function which prints values of type double going up in 
	//increments of 'i' starting from 's' and ending at 'f'
	public void increment(double s, double f, double i) {
		double n = s;
		while(n <= f) {
			System.out.println("n = " +n);
			n = n + i;
		}
	}
	
	//a timer function which runs for 'T' seconds and
	//prints the number of loops according to the value of
	//'loopSteps'
	public int timer(long T, int loopSteps) {
		
		//initialising variables and constants
		long tStart = System.currentTimeMillis();
		long t = 0;
		int n = 0;
		
		while (t <= T*1000) {
			t = System.currentTimeMillis() - tStart;
			n++;
			
			//prints loop number if condition is met
			if(n % loopSteps == 0.0) {
				System.out.println("number of loops run = "+n);
				
			}
			
		}
		
	return n;
	}
	
	public static void main(String[] args) {
		AlgorithmControl ac = new AlgorithmControl();
		
		//this calls the loop function defined above to 
		//print integers from 1 to 10
		ac.loop(1,10);
		
		//this uses the decrement loop function to print integers from 
		//5 to -12
		ac.decrement(5, -12);
		
		//this uses the increment loop function to print numbers
		//from 2.4 to 8.8 in 02. increments.
		ac.increment(2.4, 8.8, 0.2);
		//also note that the output displays some of the numbers
		//with a very small error and this may be due to the increments
		//not actually going up in 0.2 exactly.
		
		int n1 = ac.timer(8, 1000);
		int n2 = ac.timer(8, 40000);

		System.out.println("Total number of loops in run 1 = "+n1);		
		System.out.println("Total number of loops in run 2 = "+n2);
		//both runs have a run time of 8 seconds but when the function
		//is told to print the loop number every 40,000 times instead of
		//1,000 times, the total number at the end is about 1,100,000,000 and
		//720,000,000 respectively. Meaning that the 40,000 run does more 
		//loops in 8 seconds.
		//This is due to the fact that printing every 40,000 times is less 
		//intensive on the cpu because less action is undertaken by the system
		//and so more loops are completed for a given time.
	}

}
