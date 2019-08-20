package module6;

import java.util.Collection;

//interface for methods which are related to goodness of fits
//interface ensures that any class that implements must have a goodnessOfFit method which takes in a collection of data and a theory to compare fit to
public interface GoodnessOfFitCalculator {

	double goodnessOfFit(Collection<DataPoint> data, Theory theory);

}
