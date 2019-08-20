package module3;

public class ThreeVector {
	double x;
	double y;
	double z;

	//defining components of ThreeVector type
	public ThreeVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	//method to calculate magnitude of vector
	public double magnitude() {
		return Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
	}

	//method that finds unit vector in same direction as input vector
	//throws exception for zero vector
	public ThreeVector unitVector() throws Exception {
		if (this.x == 0 && this.y == 0 && this.z == 0) {
			throw new Exception("zero vector in ThreeVector.unitVector function");
		}

		double mag = this.magnitude();
		double xUnit = this.x/mag;
		double yUnit = this.y/mag;
		double zUnit = this.z/mag;

		return new ThreeVector(xUnit, yUnit, zUnit);
	}

	//method that displays vector clearly in string
	public String toString() {
		return 	"("+this.x+","+this.y+","+this.z+")";
	}

	//static method that calculates scalar product of two vectors
	public static double scalarProduct(ThreeVector vec1, ThreeVector vec2) {
		double sProd = vec1.x*vec2.x + vec1.y*vec2.y + vec1.z*vec2.z;
		return sProd;
	}

	//static method that calculates vector product of two vectors
	public static ThreeVector vectorProduct(ThreeVector vec1, ThreeVector vec2) {
		double xProd = vec1.y*vec2.z - vec1.z*vec2.y;
		double yProd = vec1.z*vec2.x - vec1.x*vec2.z;
		double zProd = vec1.x*vec2.y - vec1.y*vec2.x;

		return new ThreeVector(xProd, yProd, zProd);
	}

	//static method that finds sum of two vectors
	public static ThreeVector add(ThreeVector vec1, ThreeVector vec2) {
		return new ThreeVector(vec1.x + vec2.x, vec1.y + vec2.y, vec1.z + vec2.z);
	}

	//method that finds angle between two vectors in radians
	//throws exception for zero vector
	public static double angle(ThreeVector vec1, ThreeVector vec2) throws Exception {
		if (vec1.x == 0 && vec1.y == 0 && vec1.z == 0) {
			throw new Exception("ThreeVector.angle(1,2) arguement 1 is zero");
		}

		if (vec2.x == 0 && vec2.y == 0 && vec2.z == 0) {
			throw new Exception("ThreeVector.angle(1,2) arguement 2 is zero");
		}

		double dotProd = scalarProduct(vec1, vec2);
		double mag1 = vec1.magnitude();
		double mag2 = vec2.magnitude();

		return Math.acos(dotProd/(mag1*mag2));
	}

	//non-static scalarProduct method
	public double scalarProduct(ThreeVector vec) {
		return scalarProduct(vec, this);
	}

	//non-static vectorProduct method
	public ThreeVector vectorProduct(ThreeVector vec) {
		return vectorProduct(vec, this);
	}

	//non-static add method
	public ThreeVector add(ThreeVector vec) {
		return add(vec, this);
	}

	//non-static angle method
	public double angle(ThreeVector vec) throws Exception {
		if (vec.x == 0 && vec.y == 0 && vec.z == 0) {
			throw new Exception("1.angle(2) arguement 2 is zero");
		}

		if (this.x == 0 && this.y == 0 && this.z == 0) {
			throw new Exception("1.angle(2) arguement 1 is zero");
		}
		return angle(vec, this);
	}

}
