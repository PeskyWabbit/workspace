package lab7fall2015;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Lab7{ 
	public static String computeMessage(double inputGpa){
		String feedback = "";
		if(inputGpa >= 3.8){
			feedback = "Excellent!";
			return feedback;
		}
		else if(inputGpa >= 3.4 && inputGpa < 3.8){
			feedback = "Very Good!";
			return feedback;
		}
		else if(inputGpa >= 2.8 && inputGpa < 3.4){
			feedback = "Okay";
			return feedback;
		}
		else if(inputGpa < 2.8){
			feedback = "see your advisor";
			return feedback;
		}
		else{
			feedback = "error";
			return feedback;
		}
	}

	public static void main(String[] args) throws FileNotFoundException{
		String myReaderRef = null;
	
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Lab 7 Josh Peel");
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
										"TXT - text files", "txt");
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(new File("C:\\Java"));
		
		int picked = chooser.showOpenDialog(null);
		if (picked == JFileChooser.APPROVE_OPTION){ //user picked something
			myReaderRef = chooser.getSelectedFile().getAbsolutePath();
		}
		else{
			System.exit(0);
		}
		
		FileReader myReader = new FileReader(myReaderRef);
		Scanner input = new Scanner(myReader);
		
		String output = "";
		double gpaSum = 0.00;
		int numberOfStudents = 0;
		
		while(input.hasNextLine()){
			String readLastName = input.next();
	        String readFirstName = input.next();
	        String readMiddleName = input.next();
	        Double readGpa = input.nextDouble();
	   
	        
			Student aStudent = new Student(readLastName, readFirstName, readMiddleName, readGpa);
			String message = computeMessage(aStudent.getGPA());
			numberOfStudents++;

			
			gpaSum += aStudent.getGPA();
			output += aStudent + "   " + message + "\n";	
		}
		System.out.print("Still running");//checking for debugging purposes
		input.close();
		double gpaAvg = gpaSum / numberOfStudents;
		
		output += "\n\nInput file read: " + myReaderRef + "\n";
		output += "That file contains data on " + numberOfStudents + " students\n";
		output += "Average of all GPA's in that file is: " + gpaAvg;
		
		
		JOptionPane.showMessageDialog(null, output, "Lab 7 by Josh Peel",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
class Name{
	private String lastName, firstName, middleName;
	public Name(String studentLastName, String studentFirstName, String studentMiddleName){
		lastName = studentLastName;
		firstName = studentFirstName;
		middleName = studentMiddleName;
	}
	public String toString(){
		String studentName = firstName + " " + middleName + " " + lastName + " ";
		return studentName;
	}
}
class Student{
	private static Name name;
	private double gpa = 0.00;

	
	public Student(String newLastName, String newFirstName, 
					String newMiddleName, double newGpa){
		name = new Name(newLastName, newFirstName, newMiddleName);
		gpa = newGpa;
	}
	public double getGPA(){
		return gpa;
	}
	public String toString(){
		return name + "(" + gpa + ")";
	}
	
}

