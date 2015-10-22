package csc120lab3;

import javax.swing.*;

public class Lab3 {

	public static void main(String[] args) {
		final String TITLE_STRING = "Lab 3 by Josh Peel"; //edit this and put in your name.
		
		Box box1; // 3 variables local to main method
		Box box2;
		Box box3;
		
		String output = ""; // we will output this later with JOptionPane
		
		box1 = new Box(5, 10, 15); //this is a call to the constructor
		//now call upon some instance methods. note use of of box1 before the method
		//names. In essence, box1 is the actor performing the method.
		//Note: below the "\n" cases text that follows to start on a new line.
		output += "Box 1 says : " + box1.myDescription() + "\n";
		output += "Surface area of box 1 is: " + box1.surfaceArea() + "\n";
		
		box2 = new Box(4, 11, 13); //this is a call to the constructor
		output += "Box 2 says : " + box2.myDescription() + "\n";
		output += "Surface area of box 2 is: " + box2.surfaceArea() + "\n";
		
		box3 = new Box(4, 14, 9); //this is a call to the constructor
		output += "Box 2 says : " + box3.myDescription() + "\n";
		output += "Surface area of box 3 is: " + box3.surfaceArea() + "\n";
		
		//now we call upon an instance method that takes another box as an argument
		//in the first line, box1 is the actor and box2 is being passed to the method
		//as an argument
		
		output += "Box2 fits inside of box 1 : " + box1.willHold(box2) + "\n";
		output += "Box1 fits inside of box 2 : " + box2.willHold(box1) + "\n";
		output += "Box3 fits inside of box 1 : " + box1.willHold(box3) + "\n\n";
		
		//next line call upon the class method. Note use of box before method name
		output += "We now have a total of " + Box.howManyBoxes() + "boxes created.";
		
		//showMesageDiaglog() is a class method of the JOptionPane class. we call it here
		//INFORMATION_MESSAGE is a class constant that we pass as an argument to method call
		//showMessageDialog() is a void method, hence it does not return anyhing to us
		JOptionPane.showMessageDialog(null, output, TITLE_STRING, JOptionPane.INFORMATION_MESSAGE);
		
	}

}

class Box {
		//This class is actually a hybrid of the two flavors of classes that we discussed in 
		//class. it uses all 5 of the big things that we use into class definitions, namely: class
		//variables, class methods, instance variables, instance methods, and has a constructor method
	
		//class variable (not use of static)
		public static int boxCounter = 0;
	
		//class method. header uses static. class itself performs this method
		//this method has no need for any perameters to be passed into it, hence ()
		//it will return an int vaue to the caller, hence "int" as part of the header
	
		public static int howManyBoxes(){
			//return the value of the class variable.
			return boxCounter;
		}	
		
		// 3 instance variables [note no use of static]
		//each object of type Box will get its own copy of each of these
		//they are marked as private so that ONLY the methods of this class can access them
		private float width;
		private float length;
		private float height;
		
		//class costructor (note: no return type and method name is same as class name)
		public Box (float newWidth, float newLength, float newHeight){
			width = newWidth;
			height = newHeight;
			length = newLength;
			
			//and eachtime we do create a new Box we will also up the boxCounter by one
			boxCounter = boxCounter + 1;
		}
		
		//an instance method note the lack of static
		public float volume(){
			float answer; //this is a local variable
			answer = width * height * width;
			return answer;
			//note: could replace above three lines with just: return (width * height * length)
		} //end volume
		
		//another instance method
		public float surfaceArea(){
			//our box has sides and a bottom, but no top
			float bottomArea = length * width;
			float sidesArea = 2 * ((length * height) + (width * height));
			return (bottomArea + sidesArea);
		} //end surfaceArea
		
		//another instance method (the object returns a string that describes its size)
		//note that += causes the right hand string to be appended to the end of the string 
		//on the left side
		public String myDescription(){
			String answer;
			answer = "I am a box with a width of " + width;
			answer += ", a length of " + length;
			answer += " and a height of " + height + ".  ";
			answer += "I also happen to have a volume of " + volume() + ".";
			return answer;
		}//end my description
		
		//another instance method. this method tells us if the box given in the parameter
		//list below. (i.e. otherBox) will fit fully inside of this box. return true if it does,
		//otherwise return false. note that the other box can be turned on its side or whatever 
		//to make it fit. 
		public boolean willHold(Box otherBox){
			
		
			float myMax = Math.max(Math.max(width, length), height);
			float otherBoxMax = Math.max(Math.max(otherBox.width, otherBox.length), otherBox.height);
		
			float myMin = Math.min(Math.min(width, length), height);
			float otherBoxMin = Math.min(Math.min(otherBox.width, otherBox.length), otherBox.height);
		
			float myMid = width + length + height - myMin - myMax;
			float otherBoxMid = otherBox.width + otherBox.length + otherBox.height - otherBoxMin -
								otherBoxMax;
			
			//below && means and
			if (otherBoxMax < myMax && otherBoxMin < myMin && otherBoxMid < myMid){
				return true; //other box fits in me!
			}
			else{
				return false;
			}
		}//end willHold
		
		
}//end class Box



