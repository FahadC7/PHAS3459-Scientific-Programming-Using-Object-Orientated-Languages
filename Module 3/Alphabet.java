package module3;

import java.util.Random;
import java.lang.Character;
import java.lang.StringBuilder;
import java.lang.Integer;

public class Alphabet {

	//method that generates a random integer between 0 and 127 (inclusive)
	//the integer is cast to its corresponding char type and output
	public static char randomCharacter() {
		Random rand = new Random();
		int randInt = rand.nextInt(128);
		char randChar = (char) randInt;
		return randChar;
	}

	public static void main(String[] args) {
		StringBuilder stringObj = new StringBuilder(); //initialise StringBuilder object
		int intTotal = 0; //initialise sum of integers object
		int ExcTotal = 0; //initialise exception count object

		//loop to generate and process 250 random characters
		for (int i = 1; i <= 250; i++) {
			char rc = randomCharacter();

			//if the charcter is a letter or digit, it is appended to the StringBuilder object
			if (Character.isLetterOrDigit(rc)) {
				stringObj.append(rc);

				//tries to read character as a number to add to integer sum object
				//if character is not a number an exception is thrown and exception count updated
				try {
					int intObj = Integer.parseInt(Character.toString(rc));	
					intTotal = intTotal + intObj;
				}
				catch (Exception e) {ExcTotal = ExcTotal + 1;}

			}
		}

		System.out.println("String of Characters: " +stringObj);
		System.out.println("Number of Characters in String = " +stringObj.length());
		System.out.println("Sum of Integers in String = " +intTotal);
		System.out.println("Number of Exceptions thrown by Integer.parseInt() = " +ExcTotal);

	}

}
