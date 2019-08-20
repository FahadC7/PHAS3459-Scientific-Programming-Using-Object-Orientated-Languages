//Fahad Chohan Module 1
package module1;

public class VectorMethods {
	
	//defining a dot product function between 2 vectors (x,y,z)
	public double dotProduct (double x1, double y1, double z1, double x2, double y2, double z2) {
		double dotProd;
		dotProd = x1*x2 + y1*y2 + z1*z2;
		return dotProd;
	}
	
	//defining a magnitude function for a vector (x,y,z)
		public double magnitude (double x, double y, double z) {
			double mag = Math.sqrt(x*x + y*y + z*z);
			return mag;		
	}
	
	//defining a function to calculate he angle between 2 vectors (x,y,z)
		public double angle (double x1, double y1, double z1, double x2, double y2, double z2) {
			double dp = dotProduct(x1,y1,z1,x2,y2,z2);
			double mag1 = magnitude(x1,y1,z1);
			double mag2 = magnitude(x2,y2,z2);
			double angleRad = Math.acos( dp / (mag1 * mag2) );
			double angleDeg = Math.toDegrees(angleRad);
			return angleDeg;
	}
		

	public static void main(String[] args) {
		
		VectorMethods vm = new VectorMethods();
		
		//calling angle function to calculate
		//angle between (1,3,2) and (2,3,4)
		double angle1 = vm.angle(1, 3, 2, 2, 3, 4);
		System.out.println(angle1);
		//the result is 19.4 degrees (3.s.f)
		
		//calling angle function to calculate
		//angle between (0,0,0) and (2,3,4)
		double angle2 = vm.angle(0, 0, 0, 2, 3, 4);
		System.out.println(angle2);
		//the result is NaN because the defined function 
		//is having to do divide 0 by 0 and so produces 
		//a math error
		
	}

}
