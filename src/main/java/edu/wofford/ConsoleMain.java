package edu.wofford;

import java.util.Scanner;

public class ConsoleMain {

	public static void main(String[] args) {
		TicTacToeModel ticTacToe = new TicTacToeModel();

		Scanner keyboard = new Scanner(System.in);

		while (!ticTacToe.isWinner()) {
			System.out.println("Enter player move: ");

			int[] move = {keyboard.nextInt(), keyboard.nextInt()};
			ticTacToe.playerMove(move[0], move[1]);
			System.out.println(ticTacToe.printConsoleBoard());
		}
		if (ticTacToe.isWinner() || ticTacToe.getResult() == "Tie") {
			System.out.println(ticTacToe.getResult());
		}
	
	}

	
}