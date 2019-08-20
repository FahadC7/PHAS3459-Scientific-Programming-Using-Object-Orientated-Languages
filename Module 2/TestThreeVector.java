package module2;

public class TestThreeVector {

	public static void main(String[] args) {

		//creates 3 vectors using ThreeVector class
		ThreeVector v1 = new ThreeVector(3,5,2);
		ThreeVector v2 = new ThreeVector(2,4,1);
		ThreeVector v3 = new ThreeVector(0,0,0);

		//prints the above defined vectors
		System.out.println("v1 = " +v1);
		System.out.println("v2 = " +v2);
		System.out.println("v3 = " +v3);

		//prints the unit vector of the above defined vectors
		System.out.println("unit vector v1 = " +v1.unitVector());
		System.out.println("unit vector v2 = " +v2.unitVector());
		System.out.println("unit vector v3 = " +v3.unitVector());		

		//non-static method used to find scalar and vector products of two vectors
		System.out.println("v1 . v2 = " +v1.scalarProduct(v2));		
		System.out.println("v1 . v3 = " +v1.scalarProduct(v3));				
		System.out.println("v1 x v2 = " +v1.vectorProduct(v2));		
		System.out.println("v1 x v3 = " +v1.vectorProduct(v3));				

		//static method used to find scalar and vector products of two vectors
		System.out.println("v1 . v2 = " +ThreeVector.scalarProduct(v1,v2));		
		System.out.println("v1 . v3 = " +ThreeVector.scalarProduct(v1,v3));		
		System.out.println("v1 x v2 = " +ThreeVector.vectorProduct(v1,v2));		
		System.out.println("v1 x v3 = " +ThreeVector.vectorProduct(v1,v3));

		//non-static method used to find angle between vectors
		System.out.println("angle(v1,v2) = " +v1.angle(v2));
		System.out.println("angle(v1,v3) = " +v1.angle(v3));

		//static method used to find angle between vectors
		System.out.println("angle(v1,v2) = " +ThreeVector.angle(v1,v2));
		System.out.println("angle(v1,v3) = " +ThreeVector.angle(v1,v3));

		//printing with the toString method not present
		/*
		System.out.println(v1);
		 */
		System.out.println("When there is no toString method defined"
				+ ", printing a vectoras above , v1, gives the following line:");
		System.out.println("module2.ThreeVector@123a439b");
		System.out.println("This is showing the package and class"
				+ " the vector is in 'module2', 'ThreeVector' but it doesnt display the vectors value.");

	}

}
