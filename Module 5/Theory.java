package module5;

public class Theory {
	double n;

	//constructor that sets value of n
	public Theory(double nValue) {
		this.n = nValue;
	}

	//method that returns value of y for a given x (y = x^n)
	public double y(double x) {
		double y = Math.pow(x, n);
		return y;
	}
}
