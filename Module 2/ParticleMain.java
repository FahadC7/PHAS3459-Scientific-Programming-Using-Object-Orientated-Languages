package module2;

public class ParticleMain {

	public static void main(String[] args) {
		//creates a particle object with mass 5.2kg and viscous fluid with drag 3.6 kg/m
		FallingParticle particle = new FallingParticle(5.2, 3.6);

		//initial drop height set to 10m
		particle.setH(10);

		//particle drop is simulated with different time increments used in the loop
		System.out.println("deltaT = "+0.5);
		particle.drop(0.5);
		System.out.println("deltaT = "+0.1);
		particle.drop(0.1);
		System.out.println("deltaT = "+0.01);
		particle.drop(0.01);
		System.out.println("deltaT = "+0.001);
		particle.drop(0.001);
		System.out.println("deltaT = "+0.0001);
		particle.drop(0.0001);

		System.out.println("Using smaller time increments (deltaT) means that "
				+ "\n the particle gets closer to its true final position "
				+ "\n and speed before the loop stops. For large time increments, "
				+ "\n the final values are quite unnacurate as the large increments mean"
				+ "\n that the while loop stops quite a large amount of time after "
				+ "\n the particle goes past the container bottom.");
	}

}
