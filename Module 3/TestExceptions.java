package module3;

public class TestExceptions {

	public static void main(String[] args) {
		//Complex exceptions
		try {
			Complex comp1 = new Complex(1,1);
			Complex comp2 = new Complex(0,0);
			Complex div = Complex.divide(comp1, comp2);
			System.out.println(div);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			Complex comp1 = new Complex(0,0);
			Complex comp2 = new Complex(1,1);
			Complex div = Complex.divide(comp1, comp2);
			System.out.println(div);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			Complex comp3 = new Complex(0,0);
			Complex norm = comp3.normalised();
			System.out.println(norm);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		
		//ThreeVector exceptions
		try {
			ThreeVector vect1 = new ThreeVector(0,0,0);
			ThreeVector unitV = vect1.unitVector();
			System.out.println(unitV);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			ThreeVector vect2 = new ThreeVector(0,1,0);
			ThreeVector vect3 = new ThreeVector(0,0,0);
			double angleStat = ThreeVector.angle(vect2, vect3);
			System.out.println(angleStat);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		try {
			ThreeVector vect4 = new ThreeVector(0,1,0);
			ThreeVector vect5 = new ThreeVector(0,0,0);
			double angleNonStat = vect4.angle(vect5);
			System.out.println(angleNonStat);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		//FallingParticle exceptions
		try {
			FallingParticle particle = new FallingParticle(1, 3.6);
			particle.setH(0);
			particle.drop(0.5);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			FallingParticle particle = new FallingParticle(0, 3.6);
			particle.setH(10);
			particle.drop(0.5);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			FallingParticle particle = new FallingParticle(1, -1);
			particle.setH(10);
			particle.drop(0.5);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			FallingParticle particle = new FallingParticle(1, 3.6);
			particle.setH(10);
			particle.drop(0);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		










	}

}