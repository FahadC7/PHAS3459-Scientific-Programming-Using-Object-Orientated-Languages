package module8;

public class CountdownTask implements Runnable {

	private int runTime; //running time of count-down

	//constructor that takes run time in seconds and converts to milliseconds
	//because all calculations are done in milliseconds
	public CountdownTask(int time) {
		this.runTime = time*1000;
	}

	//method which runs timer and prints time remaining every 1 second interval
	public void run() {
		double startTime = System.currentTimeMillis();
		double endTime = startTime + runTime;

		//1000 is subtracted so that the start time of timer is printed in while loop below
		double lastSecond = System.currentTimeMillis() - 1000 ;

		//prints time remaining every 1 second interval
		while (System.currentTimeMillis() <= endTime) {
			if (System.currentTimeMillis() - lastSecond == 1000) {
				lastSecond = System.currentTimeMillis();
				double countdownTime = runTime - (System.currentTimeMillis() - startTime);
				System.out.println("count down: " +(countdownTime/1000)+ " s");
			}
		}	

		System.out.println("countdown finished");
	}

}