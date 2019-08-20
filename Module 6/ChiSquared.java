package module6;

import java.util.Collection;

//a class which calculates goodness of fit by using chi-squared method and implements goodnessOfFit interface
public class ChiSquared implements GoodnessOfFitCalculator {

	public double goodnessOfFit(Collection<DataPoint> data, Theory theory) {
		double chi = 0;

		for(DataPoint point : data) {
			chi = chi + Math.pow(point.yGet() - theory.y(point.xGet()),2) / Math.pow(point.eyGet(), 2);
		}

		return chi;
	}

}
