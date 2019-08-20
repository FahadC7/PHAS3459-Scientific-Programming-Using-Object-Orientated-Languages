package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		//try block that handles exceptions
		try {
			//creating matrices as double[][] objects
			//then creating SquareMatrix objects from arrays for each matrix

			//matrix A
			double[][] A = {{1,2,0}, {0,2,0}, {-2,0,1}};
			SquareMatrix smA = new SquareMatrix(A);		
		
			//matrix B
			double[][] B = {{2,1,0}, {0,1,0}, {-1,0,1}};
			SquareMatrix smB = new SquareMatrix(B);
			
			//matrix C
			double[][] C = {{4,3}, {3,2}};
			SquareMatrix smC = new SquareMatrix(C);

			//matrix D
			double[][] D = {{-2,3}, {3,-4}};
			SquareMatrix smD = new SquareMatrix(D);

			//matrix operations
			System.out.println("A+B: \n" +smA.add(smB)); //A+B
			System.out.println("A-B: \n" +smA.subtract(smB)); //A-B
			System.out.println("AB: \n" +smA.multiply(smB)); //AB
			System.out.println("BA: \n" +smB.multiply(smA)); //BA
			
			//A and B commuter, A and B do not commute
			System.out.println("[A,B]: \n" +SquareMatrix.subtract(smA.multiply(smB),smB.multiply(smA))); 
			
			SquareMatrix CD = smC.multiply(smD); //CD			
			System.out.println("CD: \n" +CD); 
			SquareMatrix I2 = CD.unitMatrix(2); //2x2 unit matrix
			
			//tests whether CD = unit matrix
			System.out.println("CD equal to 2x2 unit matrix: " +CD.equals(I2)); 
		}
		catch(Exception e) {System.out.println(e);}
	}
}
