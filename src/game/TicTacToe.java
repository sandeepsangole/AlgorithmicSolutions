package game;

import java.util.Scanner;

public class TicTacToe {

	public static int row, col;
	public static Scanner  scan  = new Scanner(System.in);
	public static char[][] board = new char[ 3 ][ 3 ];
	public static char     turn  = 'X';

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[ i ][ j ] = '_';
			}
		}

		printBoard();
		play();
	}

	public static void play() {

		boolean playing = true;
		while (playing) {
			System.out.println("Please entry row and col : ");

			row = scan.nextInt() - 1;
			col = scan.nextByte() - 1;

			if(row < 0 || row > 2 || col < 0 || col > 2) {
				System.out.println("Wrong Input buddy....");
				continue;
			}


			board[ row ][ col ] = turn;
			if (gameOver(row, col)) {
				playing = false;
				System.out.println("Game Over !! Player " + turn + "Wins");
			}

			printBoard();
			if (turn == 'X') {
				turn = 'O';
			} else {
				turn = 'X';
			}


		}
	}

	public static void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0)
					System.out.print("| ");
				System.out.print(board[ i ][ j ] + " | ");
			}
			System.out.println();
		}

	}

	public static boolean gameOver(int rMove, int cMove) {
		//
		if (board[ 0 ][ cMove ] == board[ 1 ][ cMove ] && board[ 0 ][ cMove ] == board[ 2 ][ cMove ]
				&& board[ 1 ][ 1 ] != '_') {
			return true;
		}

		if (board[ rMove ][ 0 ] == board[ rMove ][ 1 ] &&
				board[ rMove ][ 0 ] == board[ rMove ][ 2 ] && board[ 1 ][ 1 ] != '_') {
			return true;
		}

		if (board[ 0 ][ 0 ] == board[ 1 ][ 1 ] && board[ 1 ][ 1 ] == board[ 2 ][ 2 ]
				&& board[ 1 ][ 1 ] != '_') {
			return true;
		}

		if (board[ 0 ][ 2 ] == board[ 1 ][ 1 ] && board[ 1 ][ 1 ] == board[ 2 ][ 0 ]
				&& board[ 1 ][ 1 ] != '_') {
			return true;
		}
		return false;
	}


}
