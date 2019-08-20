package module6;

//QuadraticTheory method which implements Theory interface and creates a theory of form y = ax^2 + bx + c
public class QuadraticTheory implements Theory {

	//quadratic constants
	double a;
	double b;
	double c;

	//constructor
	public QuadraticTheory(double a, double b, double c) {
		this.a = a; this.b = b; this.c = c;
	}

	public double y(double x) {
		return this.a*Math.pow(x, 2) + this.b*x + this.c;
	}

	public String toString() {
		return this.a +"x^2 + "+ this.b +"x + "+ this.c;
	}

}
