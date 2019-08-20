package module5;

import java.util.Arrays;

public class SquareMatrix {

	double[][] M;	

	//contructer which throws IOException
	public SquareMatrix(double[][] elements) throws Exception{
		//for loop which analyses every row and column to determine if matrix is square
		for(int i=0; i<elements.length; i++) {
			if(elements.length != elements[i].length) {
				throw new Exception("matrix is not square");
			}
		}
		this.M = elements;
	}

	//toString method to display matrix in console clearly
	public String toString() {
		String mString = "";
		for(int i=0; i<M.length; i++) {
			for(int j=0; j<M.length; j++) {mString = mString +M[i][j]+ "\t";}
			mString = mString+ "\n";
		}
		return mString;
	}

	//creates unit matrix of desired size
	public static SquareMatrix unitMatrix(int size) throws Exception{
		double[][] uMatrix = new double[size][size];
		for(int i=0; i<size; i++) {
			uMatrix[i][i] = 1.0;
		}
		return new SquareMatrix(uMatrix);
	}

	//determines whether two matrices are truly equal
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(M, other.M))
			return false;
		return true;
	}

	//static method which adds two matrices together
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {

		//exception thrown if both matrices dont have same dimension
		if (sm1.M.length != sm2.M.length) {
			throw new Exception("matrices must have same demensions");
		}

		double[][] sum = new double[sm1.M.length][sm1.M.length];
		for(int i=0; i<sm1.M.length; i++) {
			for(int j=0; j<sm1.M.length; j++) {
				sum[i][j] = sm1.M[i][j] + sm2.M[i][j];
			}
		}
		return new SquareMatrix(sum);
	}

	//non-static method of matrix addition
	public SquareMatrix add(SquareMatrix m) throws Exception {
		return add(this, m);
	}

	//method which subtracts two matrices
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws Exception {

		//exception thrown fif both matrices dont have the same dimensions
		if (sm1.M.length != sm2.M.length) {
			throw new Exception("matrices must have same demensions");
		}

		double[][] sub = new double[sm1.M.length][sm1.M.length];
		for(int i=0; i<sm1.M.length; i++) {
			for(int j=0; j<sm1.M.length; j++) {
				sub[i][j] = sm1.M[i][j] - sm2.M[i][j];
			}
		}
		return new SquareMatrix(sub);
	}

	//non-static method of matrix subtraction
	public SquareMatrix subtract(SquareMatrix m) throws Exception {
		return subtract(this, m);
	}

	//method that multiplies two matrices together
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception{

		//exception thrown if both matrices dont have same dimension
		if (sm1.M.length != sm2.M.length) {
			throw new Exception("matrices must have same demensions");
		}

		double[][] mul = new double[sm1.M.length][sm1.M.length];
		for(int i=0; i<sm1.M.length; i++) {
			for(int j=0; j<sm1.M.length; j++) {
				mul[i][j] = 0;
				for(int k=0; k<sm1.M.length; k++) {
					mul[i][j] = mul[i][j] + sm1.M[i][k] * sm2.M[k][j];
				}
			}
		}
		return new SquareMatrix(mul);		
	}

	//non.static method of matrix multiplication
	public SquareMatrix multiply(SquareMatrix m) throws Exception {
		return multiply(this, m);
	}
}

