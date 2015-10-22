package Lab4;

import javax.swing.JOptionPane;

public class Lab4 {

	public static void main(String[] args) {
		final String OUTPUT_TITLE = "Lab 4 Output by CSC 120 Josh Peel";	
	
		GuessingGame game1 = new GuessingGame (1, 10); // number to guess between
	
		//test use of summary() instance method if it is called before game is over
		JOptionPane.showMessageDialog(null, game1.summary(), OUTPUT_TITLE,
									JOptionPane.INFORMATION_MESSAGE);
	
		int guess;
		String userInputString;
	
		//we will loop playing the game until the game reports that it is over
		do{
			userInputString = JOptionPane.showInputDialog("enter your next guess.");
		
			//FYI: in next line we call a class (Integer) method to help us make
			//a conversion from string to int. Integer class is in java.lang package
			guess = Integer.parseInt(userInputString);
		
			String outcomeOfGuess = game1.makeGuess(guess);
			JOptionPane.showMessageDialog(null, outcomeOfGuess, OUTPUT_TITLE, 
										JOptionPane.INFORMATION_MESSAGE);

		} while (game1.isOnGoing());
	
		JOptionPane.showMessageDialog(null, game1.summary(), OUTPUT_TITLE,
									JOptionPane.INFORMATION_MESSAGE);
	
		//in the next line we attempt to make another guess after the game is over. this
		//should lead to a message being returned to tell us that the game is over. in a
		//"properly" constructed use of the guessinggame classt this would never happen.
		//we just test code to be sure it works
		JOptionPane.showMessageDialog(null, game1.makeGuess(guess), OUTPUT_TITLE,
									JOptionPane.INFORMATION_MESSAGE);
	}//main
}//class 

class GuessingGame {
	
	private int high;
	private int low;
	private int answer;
	private int totalGuessCount;
	private int lowGuessCount;
	private int highGuessCount;
	private boolean trueOrFalse = true;
	
	//constructor  
	public GuessingGame(int newLow, int newHigh){
		high = newHigh;
		low = newLow;
		answer = (int)((high - low + 1)* Math.random()) + low;
	}
	
	public String summary(){
		String summaryText;
		summaryText = "so far you have made " + totalGuessCount + " guesses." +  "\n";
		summaryText += "of those guesses, " + lowGuessCount + " have been too low and " 
						+ highGuessCount + " have been too high.";
		return summaryText;
	}
	
	public String makeGuess(int guess){
		String text;
		if(trueOrFalse == false){
			return text = "you cannot make a guess while the game is not going";
		}
		
		else if(guess == answer){
			text = "Your guess was correct!";
			totalGuessCount = totalGuessCount + 1;
			trueOrFalse = false;
			return text;
		}
		else if (guess > answer){
			text = "Your guess of " + guess + " was too high that time";
			totalGuessCount = totalGuessCount + 1;
			highGuessCount = highGuessCount + 1;
			trueOrFalse = true;
			return text;
		}
		else if (guess < answer){
			text = "Youre guess of " + guess + " was too low that time";
			totalGuessCount = totalGuessCount + 1;
			lowGuessCount = lowGuessCount + 1;
			trueOrFalse = true;
			return text;
		}
		else if (guess > high || guess < low){
			text = "your guess of " + guess + "was out of bounds";
			trueOrFalse = true;
			return text;
		}
		return text = "this is here to stop an error.";
		
	}
	public boolean isOnGoing(){
		return trueOrFalse;
	}
}	
	
	
