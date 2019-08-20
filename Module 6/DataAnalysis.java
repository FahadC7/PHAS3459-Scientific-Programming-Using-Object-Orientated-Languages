package module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis {

	//method that takes in collections of data and theories and a method of measuring the goodness of the fit
	//the best fitting theory for the data collection is then outputted
	private static Theory bestTheory(Collection<DataPoint> data,
			Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {

		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;

		//for loop which cycles over all the theories in the collection and calculates their goodness of fit (gof) value
		//the theory with the lowest gof value is set to bestTheory and outputted
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(data, theory);
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		return bestTheory;
	}

	public static void main(String[] args) {

		//initialises fits so that they can be added to theory ArrayList below
		PowerLawTheory fit1 = new PowerLawTheory(2); //y = x^2
		PowerLawTheory fit2 = new PowerLawTheory(2.05); //y = x^2.05
		QuadraticTheory fit3 = new QuadraticTheory(1,10,0); //y = x^2 + 10x

		//method used in calculating goodnessOfFit
		ChiSquared chi = new ChiSquared();

		//creates theories ArrayList and adds all above created theories
		ArrayList<Theory> theoryArray = new ArrayList<Theory>();
		theoryArray.add(fit1);
		theoryArray.add(fit2);
		theoryArray.add(fit3);

		try {
			//finds best theory by using bestTheory method above
			Theory bestTheory = bestTheory(TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt"), theoryArray, chi);
			System.out.println("best theory: " +bestTheory);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
