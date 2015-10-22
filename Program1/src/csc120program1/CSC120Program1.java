package csc120program1;  // Your package name might differ, that is ok.

import javax.swing.JOptionPane;

//  Put your global documentation up here!!!
//  Josh Peel
//  CSC120 fall semester 6pm Tues/thurs
//	I forgot exactly what was supposed to gere
//	MarbleSack class authored by Josh Peel

public class CSC120Program1 {
	
	final static  String OUTPUT_TITLE = "CSC Program 1 by CSC Josh Peel"; // Edit to your name.
	
	// Our main method just acts as a test bed for our MarbleSack class.
	// We use it to create objects of our class and then to call upon the
	// various methods that the class offers.
	public static void main(String[] args) {
	
		MarbleSack sack1,  sack2, sack3;
		
		// Create MarbleSacks.  Calls to the constructor.
		sack1 = new MarbleSack("red"  , 5);  // color is red and capacity is 5 marbles
		sack2 = new MarbleSack("white", 10);
		sack3 = new MarbleSack("blue" , 15);
		
		String output = "Test of sackDescription method. \n";
		output += sack1.sackDescription() + "\n";
		output += sack2.sackDescription() + "\n";
		output += sack3.sackDescription() + "\n";
		JOptionPane.showMessageDialog(null, output, OUTPUT_TITLE + " Screen 1", 
						JOptionPane.INFORMATION_MESSAGE);
		
		output = "Test of getColor, getCapacity, and getCurrentCount methods. \n";
		output += sack3.getColor() + " sack can hold " + sack3.getCapacity() + 
			  " marbles, but now holds " + sack3.getCurrentCount() + "\n";
		output += sack2.getColor() + " sack can hold " + sack2.getCapacity() + 
			  " marbles, but now holds " + sack2.getCurrentCount() + "\n";
		output += sack1.getColor() + " sack can hold " + sack1.getCapacity() + 
			  " marbles, but now holds " + sack1.getCurrentCount() + "\n";	
		JOptionPane.showMessageDialog(null, output, OUTPUT_TITLE + " Screen 2",
			  JOptionPane.INFORMATION_MESSAGE);
		
		// If howMuchSapceLeft reports a bad value, just bomb and say so.
		// At this point, not having added any marbles yet, the remaining space should 
		// match the capacity.
		// "!=" means NOT EQUAL and "||" is OR.
		if (sack1.howMuchSpaceLeft() != sack1.getCapacity() || 
		    sack2.howMuchSpaceLeft() != sack2.getCapacity() ||
		    sack3.howMuchSpaceLeft() != sack3.getCapacity()) {
			output = "Error in howMuchSpaceLeft method.";
			JOptionPane.showMessageDialog(null, output, OUTPUT_TITLE + 
					" Error detected!!", JOptionPane.ERROR_MESSAGE);
			System.exit(0);  // Stops program!
		}
	
		output = "Test of isBiggerThan method (it returns a boolean). \n";
		output += sack1.getColor() + " sack is bigger than " + sack2.getColor() + 
			  " sack : " + sack1.isBiggerThan(sack2) + "\n";
		output += sack2.getColor() + " sack is bigger than " + sack1.getColor() + 
			  " sack : " + sack2.isBiggerThan(sack1) + "\n";
		output += sack2.getColor() + " sack is bigger than " + sack3.getColor() + 
			  " sack : " + sack2.isBiggerThan(sack3) + "\n";
		output += sack3.getColor() + " sack is bigger than " + sack1.getColor() + 
			  " sack : " + sack3.isBiggerThan(sack1) + "\n";
		JOptionPane.showMessageDialog(null, output, OUTPUT_TITLE + " Screen 3",
			  JOptionPane.INFORMATION_MESSAGE);
		

		output = "Test of addMarbles(...) method (it is void).  Adding 2, 3 and 4. \n";
		sack1.addMarbles(2);  sack2.addMarbles(3); sack3.addMarbles(4);
		output += sack1.sackDescription() + "\n";
		output += sack2.sackDescription() + "\n";
		output += sack3.sackDescription() + "\n";
		JOptionPane.showMessageDialog(null, output, OUTPUT_TITLE + " Screen 4",
						 JOptionPane.INFORMATION_MESSAGE);
		

		if (sack1.howMuchSpaceLeft() != 3 || sack2.howMuchSpaceLeft() != 7 || 
		    sack3.howMuchSpaceLeft() != 11) {
			output = "Error in addMarble or howMuchSpaceIsLeft methods.";
			JOptionPane.showMessageDialog(null, output, OUTPUT_TITLE + 
					" Error detected!!", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		
		output = "Test of removeMarbles(...) method (it is void).  removing one each. \n";
		sack1.removeMarbles(1);  sack2.removeMarbles(1); sack3.removeMarbles(1);
		output += sack1.sackDescription() + "\n";
		output += sack2.sackDescription() + "\n";
		output += sack3.sackDescription() + "\n";
		JOptionPane.showMessageDialog(null, output, OUTPUT_TITLE + " Screen 5", 
						JOptionPane.INFORMATION_MESSAGE);
		
		if (sack1.howMuchSpaceLeft() != 4 || sack2.howMuchSpaceLeft() != 8 || 
		    sack3.howMuchSpaceLeft() != 12) {
			output = "Error in removeMarble or howMuchSpaceIsLeft methods.";
			JOptionPane.showMessageDialog(null, output, OUTPUT_TITLE + 
						" Error detected!!", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		
		output = "Test of addMarbles(...) method.  Adding 5, 8 and 12. Is red 5 now? \n";
		sack1.addMarbles(5);  sack2.addMarbles(8); sack3.addMarbles(12);
		output += sack1.sackDescription() + "\n";  // 5 now if clever, otherwise 6.
		output += sack2.sackDescription() + "\n";  // 10 now
		output += sack3.sackDescription() + "\n";  // 15 now
		JOptionPane.showMessageDialog(null, output, OUTPUT_TITLE + " Screen 6",
						JOptionPane.INFORMATION_MESSAGE);

		output = "Test of removeMarbles(...) method.  Removing 5, 11 and 15. \n";
		sack1.removeMarbles(5);  sack2.removeMarbles(11); sack3.removeMarbles(15);
		output += sack1.sackDescription() + "\n";  // 0 not 1?
		output += sack2.sackDescription() + "\n";  // Should say 0 not -1??
		output += sack3.sackDescription() + "\n";
		JOptionPane.showMessageDialog(null, output, OUTPUT_TITLE + " Screen 7",
						JOptionPane.INFORMATION_MESSAGE);
		
		if (sack1.howMuchSpaceLeft() != 5 || sack2.howMuchSpaceLeft() != 10 || 
		    sack3.howMuchSpaceLeft() != 15) {
			output = "FYI: Wimpy version of add/remove marbles was used.!";
			JOptionPane.showMessageDialog(null, output, OUTPUT_TITLE + " Screen 8", 
						JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}

	}  // end main
	
} // end class CSC120Program1

// Add your code below.  Do not modify main method.
class MarbleSack {
	// Instance variables.
	private String color;
	private int capacity;
	private int count;
	private String output;
	final static String OUTPUT_TITLE = "CSC Program 1 by CSC Josh Peel";
	
	// Constructor.
	public MarbleSack(String newColor, int newCapacity){
		capacity = newCapacity;
		color = newColor;
	}
	// 8 Instance methods.
	public String sackDescription(){
		return output = "Sack is " + color + ", it can hold " + capacity + ". it currently holds " + count;
		
	}
	
	public String getColor(){
		return color;
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public int getCurrentCount(){
		return count;
	}
	
	public int howMuchSpaceLeft(){
		int answer;
		answer = capacity - count;
		return answer;
	}
	
	public boolean isBiggerThan(MarbleSack otherSack){
		int mySackSize = capacity;
		int otherSackSize = otherSack.capacity;
		
		if (mySackSize > otherSackSize){
			return true;
		}	
		else {
			return false;
		}	
	}
	
	public void addMarbles(int addNumber){
		int add = addNumber;
		count = count + add;
		if (capacity < count){
			count = capacity;
		}
		
	}
	
	public void removeMarbles(int subtractNumber){
		int subtract = subtractNumber;
		count = count - subtract;
		if (count < 0){
			count = 0;
		}
	}
	
} // end class MarbleSack
