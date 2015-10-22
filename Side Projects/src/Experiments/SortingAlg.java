package Experiments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SortingAlg {

	public static void main(String[] args) throws IOException {
		String myReaderRef = null;
		
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Sorting Algorithm test");
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
		int arraySize = 0;
		while(input.hasNextLine()){
			arraySize++;
			input.nextLine();
		}
		input.close();
		myReader.close();
		
		int[] numbers;
		numbers = new int[arraySize];
		
		myReader = new FileReader(myReaderRef);
		input = new Scanner(myReader);
		
		while(input.hasNextLine()){
			for(int i=0; i < numbers.length; i++){
				numbers[i] = input.nextInt();
			}
		}
		input.close();
		
		for(int i = (numbers.length-1); i >= 0; i--){
			for(int j=0; j < i; j++){
				if(numbers[j] > numbers[j+1]){
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;	
				}
			}
		}
		int returnVal2 = chooser.showSaveDialog(null);
		String myWriterRef = null;
		
		if (returnVal2 == JFileChooser.APPROVE_OPTION){
			myWriterRef = chooser.getSelectedFile().getAbsolutePath();
		}
		else{
			System.exit(0);
		}
		
		FileWriter myWriter = new FileWriter(myWriterRef);
		PrintWriter outputFile = new PrintWriter(myWriter);
		
		for(int i = 0; i < numbers.length; i++){
			outputFile.println(numbers[i]);
		}
		outputFile.close();
	}
}


