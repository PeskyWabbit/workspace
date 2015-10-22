package csc120lab9;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ArrayGame {

	public static void main(String[] args) {
		String roundsInput = "";
		String player1 = "";
		String player2 = "";
		
		roundsInput = JOptionPane.showInputDialog("Enter number of rounds were played.");
		player1 = JOptionPane.showInputDialog("Enter player 1 name.");
		player2 = JOptionPane.showInputDialog("Enter player 2 name.");
		
		
		int rounds = Integer.parseInt(roundsInput);
		int[] game1;
		int[] game2;
		game1 = new int[rounds];
		game2 = new int[rounds];
		
		inputScores(game1, player1);
		inputScores(game2, player2);
		
		compareScores(game1, game2, player1, player2);
		JTextArea text = new JTextArea(5,30);
		JScrollPane scroll = new JScrollPane(text);
		text.setText(compareScores(game1, game2, player1, player2));

		JOptionPane.showMessageDialog(null, scroll, "Lab 9 by Josh Peel",
										JOptionPane.INFORMATION_MESSAGE);
		
		
		}

	private static void inputScores(int[] game, String name) {
		for(int i=0; i < game.length; i++){
			String input;
			input = JOptionPane.showInputDialog(name + ", Enter your score for game" + (i+1));
			int score = Integer.parseInt(input);
			game[i] = score;
		}
	}
	
	public static String compareScores(int[] p1, int[] p2, String name1, String name2){
		String output = "";
		int p1Wins = 0;
		int p2Wins = 0;
		int ties = 0;
		for(int i=0; i < p1.length; i++){
			if(p1[i] > p2[i]){
				output += "game " + (i+1) + " results:\n";
				output += name1 + " outscored " + name2 + " by ";
				output += (p1[i] - p2[i]) + " points \n\n";
				p1Wins++;
			}
			else if(p1[i] < p2[i]){
				output += "game " + (i+1) + " results:\n";
				output += name2 + " outscored " + name1 + " by ";
				output += (p2[i] - p1[i]) + " points\n\n";
				p2Wins++;
			}
			else if(p1[i] == p2[i]){
				output += "game " + (i+1) + " results:\n";
				output += name1 + " and " + name2 + " had the same score\n\n";
				ties++;
			}
			else
				output = "error";
		}
		String winOrWins;
		switch (p1Wins){
			case 1: winOrWins = "win"; break;
			default: winOrWins = "wins";
		}	
		
		output += p1Wins + " " + winOrWins + " for " + name1 + "\n";
		
		switch (p2Wins){
			case 1: winOrWins = "win"; break;
			default: winOrWins = "wins";
		}
		output += p2Wins + " " + winOrWins + " for " + name2 + "\n";
		
		switch (ties){
			case 1: winOrWins = "tie"; break;
			default: winOrWins = "ties";
		}
		output += ties + " " + winOrWins + "\n";
		return output;	
	}
}

