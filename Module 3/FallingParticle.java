package module3;

public class FallingParticle {

	static double m; //mass of particle (kg)
	static double d; //drag coefficient of fluid (kg/m)
	static double t; //time elapsed (s)
	static double z; //vertical position of particle (m)
	static double h; //initial height of particle (m)
	static double v; //velocity of particle (m/s)
	static final double g = 9.81; //acceleration due to gravity on Earth (m/s^2)

	//defining components of FallingParticle type
	public FallingParticle(double mass, double drag) {
		m = mass;
		d = drag;
	}

	//method that sets value of h
	public void setH(double hNew) {
		FallingParticle.h = hNew;
		System.out.println("Initial height set to: "+h+"m");
	}

	//method that returns value of current particle vertical height
	public static double getZ() {
		return z;
	}

	//method that sets value of velocity
	public static void setV(double vNew) {
		FallingParticle.v = vNew;
		System.out.println("Velocity set to: "+v+"m/s");
	}

	//method that returns value of velocity
	public static double getV() {
		return v;
	}

	//method that returns time elapsed so far
	public double getT() {
		return t;
	}

	//method that calculates new values of vertical position and velocity after
	//a small increment of time deltaT
	public static void doTimeStep(double deltaT) {		
		double a = (d*v*v)/m - g;
		double dv = a*deltaT;
		double dz = v*deltaT;

		v = v + dv;
		z = z + dz;
	}

	//method that simulates the dropping of the particle
	//throws exceptions for unphysical conditions
	public void drop(double deltaT) throws Exception {
		if (m <= 0) {
			throw new Exception("input mass is negative or zero");
		}

		if (h <= 0) {
			throw new Exception("initial height is negative or zero");
		}

		if (d < 0) {
			throw new Exception("drag coefficient is negative");
		}

		if (deltaT <= 0) {
			throw new Exception("timestep is negative or zero");
		}

		t = 0;
		z = h;
		v = 0;

		//while loop runs until particle hits container
		while(z >= 0.0) {
			t = t + deltaT;
			FallingParticle.doTimeStep(deltaT);
		}

		System.out.println("Final time:"+t+"s");
		System.out.println("Final velocity:"+v+"m/s");
	}	

}
