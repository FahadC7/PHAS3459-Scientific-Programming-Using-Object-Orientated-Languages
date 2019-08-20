package module6;

//subclass that inherits from DataPoint class
public class LabelledDataPoint extends DataPoint {

	String data_point_label; //data point label

	//constructor which passes x, y and y error values to superclass
	public LabelledDataPoint(double xVal, double yVal, double eyVal, String lab) {
		super(xVal,yVal,eyVal);
		data_point_label = lab;
	}

	//toString method
	public String toString() {
		return data_point_label+ ": x = " +x+ ", y = " +y+ " +- " +ey;
	}

}
