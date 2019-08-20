package module5;

public class DataPoint {
	double x; //x values
	double y; //y values
	double ey; // y error
	
	//constructor
	public DataPoint(double xValue, double yValue, double eyValue) {
		this.x = xValue; this.y = yValue; this.ey = eyValue;
	}
	
	//getter methods for x, y and ey
	public double xGet() {return this.x;}
	public double yGet() {return this.y;}
	public double eyGet() {return this.ey;}
}
