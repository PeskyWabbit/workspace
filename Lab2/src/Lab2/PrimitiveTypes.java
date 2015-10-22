package Lab2;
import javax.swing.*;
public class PrimitiveTypes {
	
	
	public static void main(String[] args) {
		byte 	aByte; //1 byte roughly -128 to 128
		short	aShort;//2 bytes roughly -32k to 32k
		int 	anInt; //4 bytes roughly -2bil to 2bil
		long 	aLong; //8 bytes roughly -2^63 to 2^63
		
		float 	aFloat;//4 bytes
		double 	aDouble;//8 bytes
		
		boolean aBoolean;//1 byte holds true/false statement
		char 	aChar;	 //2 bytes because unicode is used
		
		
		String myName	= new String("Joe Blow");
		String yourName	= "Jane Doe"; // short for above line
		String userInput;
		String output;
		int intInput;
		
		output = "Hello... I am " + myName + "\n";
		output += "11/3 is " +  (11/3) + " [Notice truncation - not 3.666!]\n";
		output += "11 % 3 is " + (11%3) + " [% is mod operator.]\n";
		
		userInput = JOptionPane.showInputDialog("Enter an integer: ");
		intInput = Integer.parseInt(userInput); //convert string to int
		
		if(intInput % 2 == 0)
			output += intInput + " is an even number";
		else 
			output += intInput + " is an odd number";
		
		JOptionPane.showMessageDialog(null, output, "Lab 2 by Josh Peel", JOptionPane.PLAIN_MESSAGE);

	}

}