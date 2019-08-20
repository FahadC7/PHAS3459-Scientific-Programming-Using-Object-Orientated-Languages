package module2;

public class TestComplex {

	public static void main(String[] args) {
		//two complex numbers defined by Complex class
		Complex c1 = new Complex(1,2);
		Complex c2 = new Complex(-2,-1);

		//product of c1 and c2
		System.out.println("c1*c2 = "+Complex.multiply(c1, c2));

		//ratio c1/c2
		System.out.println("c1/c2 = "+Complex.divide(c1, c2));

		//product of c1 and I
		System.out.println("c1*I = "+Complex.multiply(c1, Complex.I));		

		//ratio c1/0
		System.out.println("c1/0 = "+Complex.divide(c1, Complex.ZERO));

		//product of c1 with conjugate of c1
		System.out.println("c1*con(c1) = "+Complex.multiply(c1, c1.conjugate()));		

		//product of c2 with conjugate of c2
		System.out.println("c2*con(c2) = "+Complex.multiply(c2, c2.conjugate()));		

	}

}
