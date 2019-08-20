package module6;

public class DataPoint {
	double x; //x values
	double y; //y values
	double ey; //y error values

	//constructors
	public DataPoint() {
		this.x = 0; this.y = 0; this.ey = 0;
	}
	public DataPoint(double xValue, double yValue, double eyValue) {
		this.x = xValue; this.y = yValue; this.ey = eyValue;
	}	

	//getter methods for x, y and ey
	public double xGet() {return this.x;}
	public double yGet() {return this.y;}
	public double eyGet() {return this.ey;}

	//toString method 
	public String toString() {
		return "x = " +x+ ", y = " +y+ " +- " +ey;
	}
}
