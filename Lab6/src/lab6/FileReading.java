package lab6;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.*;

public class FileReading {

	public static void main(String[] args) throws IOException {
		String myReaderRef = null;
		String myWriterRef = null;
		JFileChooser chooser = new JFileChooser();
		
		chooser.setDialogTitle("Lab 6 (Select a file to read) - CSC 120 Josh Peel");
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
										"TXT - text files", "txt");
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(new File("C:\\Java"));
		
		int returnVal = chooser.showOpenDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION){ //user picked something
			myReaderRef = chooser.getSelectedFile().getAbsolutePath();	
		}
		else{
			System.exit(0);
		}
		
		
		chooser.setDialogTitle("Lab 6 (Select a file to write to) - CSC 120 Josh Peel");
		
		int returnVal2 = chooser.showSaveDialog(null);
		
		if (returnVal2 == JFileChooser.APPROVE_OPTION){
			myWriterRef = chooser.getSelectedFile().getAbsolutePath();
		}
		else{
			System.exit(0);
		}
		
		FileReader myReader = new FileReader(myReaderRef);
		Scanner inputFile = new Scanner (myReader);
		
		FileWriter myWriter = new FileWriter(myWriterRef);
		PrintWriter outputFile = new PrintWriter(myWriter);
		
		int helpCount = 0;
		while(inputFile.hasNextLine()){
			String line = inputFile.nextLine();
			if(line.contains("help")){
				outputFile.println(line);
				helpCount++;
				outputFile.println("\n");
			}
			else{
			}
		}
		inputFile.close();
		
		String output = "Lab 6 by Josh Peel. " + "\n";
		output += "File Read: " + myReaderRef + "\n";
		output += "Number of lines above that contain \"here\" is " + helpCount;
		
		outputFile.print(output);
		
		outputFile.close();
	}
		
}

