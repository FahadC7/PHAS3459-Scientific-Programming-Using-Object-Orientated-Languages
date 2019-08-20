package module6;

//PowerLawTheory method which implements Theory interface and creates a theory of form y = x^n
public class PowerLawTheory implements Theory{

	double n; //power value

	//constructor
	public PowerLawTheory(double power) {n = power;}

	public double y(double x) {return Math.pow(x,n);}

	public String toString() {return "x^" +n;}

}
