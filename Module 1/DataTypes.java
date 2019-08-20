//Fahad Chohan Module 1
package module1;

public class DataTypes {

	public static void main(String[] args) {
		
		//Creating variables and printing them
		double doubVar = (double) 10.0;
		System.out.println("doubVar = " +doubVar);				
		float floatVar = (float) 10.0;
		System.out.println("floatVar = " +floatVar);	
		int intVar = (int) 10;
		System.out.println("intVar = " +intVar);
		long longVar = (long) 10;
		System.out.println("longVar = " +longVar);
		byte byteVar = (byte) 10;
		System.out.println("byteVar = " +byteVar);
		
		//printing the square of the above variables
		System.out.println("doubVar squared = " +doubVar*doubVar);
		System.out.println("floatVar squared = " +floatVar*floatVar);
		System.out.println("intVar squared = " +intVar*intVar);
		System.out.println("longVar squared = " +longVar*longVar);
		System.out.println("byteVar squared = " +byteVar*byteVar);
		
		
		//mixing variables
		
		char charMix = 'c' + 10;
		System.out.println("charMix = "+charMix);
		System.out.println("Adding 10 (int) to 'c' (char) outputs 'm' because this is the 10th letter after 'c'");
		
		
		double intMix = 10 + 10.5;
		System.out.println("intMix = "+intMix);
		System.out.println("Adding a double and an int results in an output as a double, the int is converted to a double");
		
		//A boolean and int mix addition gives an error as
		//it is not possible because arithmetic methods do not
		//work with booleans
		
		/*
		boolean boolMix = 'true' + 1;
		System.out.println("boolMix = "+boolMix);
		*/
		
		/*
		int j=1; int i; j=i+1;
		*/
		//i is unassigned and therefore results in an error
		
		double doubVar2 = 4.99;
		int intVar2 = (int) doubVar2;
		System.out.println("intVar2 = "+intVar2);
		System.out.println("only the integer value of the double is used when cast");

	}

}
