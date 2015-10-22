package programtwo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JOptionPane;



public class CSC120Program2 {
	//big owner class method
	public static String bigOwner(MarbleSackOwner owner1, MarbleSackOwner owner2, MarbleSackOwner owner3,
			 				MarbleSackOwner owner4){
		String biggest = null;
		if(owner1.howManyMarbles() > owner2.howManyMarbles()
			&& owner1.howManyMarbles() > owner3.howManyMarbles()
			&& owner1.howManyMarbles() > owner4.howManyMarbles())
			return biggest = owner1.getName();
		
		else if(owner2.howManyMarbles() > owner3.howManyMarbles()
				&& owner2.howManyMarbles() > owner4.howManyMarbles())
			return biggest = owner2.getName();
		
		else if(owner3.howManyMarbles() > owner4.howManyMarbles())
			return biggest = owner3.getName();
		
		else if(owner4.howManyMarbles() > owner4.howManyMarbles())
			return biggest = owner4.getName();
		else 
			return biggest = "error";
			
	}

	public static void main(String[] args) throws FileNotFoundException {
		final String TITLE_BAR = "Output by CSC120 Josh Peel";
		final String INPUT_FILE_NAME = "C:\\Java\\MarbleData.txt"; //hardwired
		
		FileReader myReader = new FileReader(INPUT_FILE_NAME);
		Scanner inputFile = new Scanner (myReader);

		String nameFromFile;
		String colorFromFile;
		int capacityFromFile;
		int currentCountFromFile;
		
		MarbleSackOwner owner1 = null, owner2 = null, owner3 = null, owner4 = null;
		
		while(inputFile.hasNextLine()){
			nameFromFile = inputFile.next();
			colorFromFile = inputFile.next();
			capacityFromFile = inputFile.nextInt();
			currentCountFromFile = inputFile.nextInt();
			
			owner1 = new MarbleSackOwner(nameFromFile, colorFromFile,
										capacityFromFile, currentCountFromFile);
			
			
			nameFromFile = inputFile.next();
			colorFromFile = inputFile.next();
			capacityFromFile = inputFile.nextInt();
			currentCountFromFile = inputFile.nextInt();
			
			owner2 = new MarbleSackOwner(nameFromFile, colorFromFile,
										capacityFromFile, currentCountFromFile);
			
			nameFromFile = inputFile.next();
			colorFromFile = inputFile.next();
			capacityFromFile = inputFile.nextInt();
			currentCountFromFile = inputFile.nextInt();
			
			owner3 = new MarbleSackOwner(nameFromFile, colorFromFile,
										capacityFromFile, currentCountFromFile);
			
			nameFromFile = inputFile.next();
			colorFromFile = inputFile.next();
			capacityFromFile = inputFile.nextInt();
			currentCountFromFile = inputFile.nextInt();
			
			owner4 = new MarbleSackOwner(nameFromFile, colorFromFile,
										capacityFromFile, currentCountFromFile);
			
		}
		inputFile.close();
		
		String output = "Owners after creaton based on file read \n";
		output += "Owner1: " + owner1 + "\n";
		output += "Owner2: " + owner2 + "\n";
		output += "Owner3: " + owner3 + "\n";
		output += "Owner4: " + owner4 + "\n";
		
		output += "owner1's name is " + owner1.getName() + "\n";
		output += "like I said, owner1 has " + owner1.howManyMarbles() + 
					" marbles in his sack.\n";
		output += "So lets take one away from him.\n";
		owner1.removeMarbles(1);
		output += "so now we see that he has " + owner1.howManyMarbles() +
					" in his sack.\n";
		
		output += "so lets give the darn thing back to him now.\n";
		owner1.addMarbles(1);
		output += "so now we see that he has " + owner1.howManyMarbles() +
					" in his sack.\n";
		
		//mess with owner4
		output += "so, maybe " + owner4.getName() +
					" has lost a marble or two, so lets give him back one.\n";
		owner4.addMarbles(1);
		output += "So now we see that he has " + owner4.howManyMarbles() + 
					" marbles in his sack.\n\n";
		
		//test class method 
		output += "the owner with the most marbles is " +
					bigOwner(owner1, owner2, owner3, owner4);
		
		//results
		JOptionPane.showMessageDialog(null, output, TITLE_BAR, JOptionPane.INFORMATION_MESSAGE);
		
	}//main

}//CSCProgram2
class MarbleSack{
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
	public MarbleSack(String newColor, int newCapacity, int newCount){
		color = newColor;
		capacity = newCapacity;
		count = newCount;
	}
	// 8 Instance methods.
	public String toString(){
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

class MarbleSackOwner{
	String name;
	MarbleSack mySack;
	
	public MarbleSackOwner(String newName, String newColor, int newCapacity, int newCount){
		name = newName;
		mySack = new MarbleSack(newColor, newCapacity, newCount);
	}
	
	public String toString(){
		String message;
		message = name + " owns a marble sack. " + mySack;
		return message;
	}
	
	public int howManyMarbles(){
		return mySack.getCurrentCount();
	}
	
	public void removeMarbles(int subtractNumber){
		mySack.removeMarbles(subtractNumber);
	}
	
	public String getName(){
		return name;
	}
	
	public void addMarbles(int addNumber){
		mySack.addMarbles(addNumber);
	}
}
