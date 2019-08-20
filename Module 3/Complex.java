package module3;

public class Complex {
	double x;
	double y;

	//defining components of the Complex type
	public Complex (double real, double imag) {
		x = real;
		y = imag;
	}

	//method that returns real part of the complex number
	public double real() {
		return this.x;
	}

	//method that returns the imaginary part of the complex number
	public double imag() {
		return this.y;
	}

	//method that finds modulus of complex number
	public double modulus() {
		return Math.sqrt(this.x*this.x + this.y*this.y);
	}

	//method that finds argument of complex number in
	public double angle() {
		return Math.atan2(this.y,this.x);
	}

	//method to find complex conjugate
	public Complex conjugate() {
		return new Complex(this.x, -1.0*this.y);
	}

	//method that finds normalised complex number
	//throws exception for zero complex number 
	public Complex normalised() throws Exception {
		if (this.x == 0 && this.y == 0) {
			throw new Exception("Complex.nomalised() input is zero");
		}

		double mag = this.modulus();
		double realNorm = this.x/mag;
		double imagNorm = this.y/mag;

		return new Complex(realNorm, imagNorm);
	}

	//method that determines whether two complex numbers are equal
	public boolean equals(Complex c) {
		if(this.x == c.x && this.y == c.y) {
			return true;
		}
		else {
			return false;
		}
	}

	//toString method that presents complex number in correct format
	public String toString() {
		return +this.x+" + "+this.y+"i";
	}

	//finds the complex number from its modulus and angle
	public Complex setFromModulusAngle(double mod, double angle) {
		double real = mod*Math.cos(angle);
		double imag = mod*Math.sin(angle);

		return new Complex(real, imag);
	}

	//method that adds together two complex numbers com1 and com2
	public static Complex add(Complex com1, Complex com2) {
		return new Complex(com1.x+com2.x, com1.y+com2.y);
	}

	//method that subtracts two complex numbers, com1 - com2
	public static Complex subtract(Complex com1, Complex com2) {
		return new Complex(com1.x-com2.x, com1.y-com2.y);
	}

	//method that multiplies two complex numbers together
	public static Complex multiply(Complex com1, Complex com2) {
		double real = com1.x*com2.x - com1.y*com2.y;
		double imag = com1.x*com2.y + com1.y*com2.x;

		return new Complex(real, imag);
	}

	//method that divides complex number com1 by com2
	//throws exception for zero complex numbers
	public static Complex divide(Complex com1, Complex com2) throws Exception {
		if (com1.x == 0 && com1.y == 0) {
			throw new Exception("Complex.divide(1,2) arguement 1 is zero");
		}

		if (com2.x == 0 && com2.y == 0) {
			throw new Exception("Complex.divide(1,2) arguement 2 is zero");
		}

		double topReal = com1.x*com2.x - com1.y*com2.y;
		double topImag = com1.x*com2.y + com1.y*com2.x;
		double bottom = com2.x*com2.x + com2.y*com2.y;

		double real = topReal/bottom;
		double imag = topImag/bottom;



		return new Complex(real, imag);
	}

	//static variables for 1, 0 and i
	static final Complex ONE = new Complex(1,0);
	static final Complex ZERO = new Complex(0,0);
	static final Complex I = new Complex(0,1);

}
