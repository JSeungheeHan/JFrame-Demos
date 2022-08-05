package solve;

import java.util.ArrayList;
import java.util.*;

public class solver {
	public static int[][] sud = {
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
	};
	
	private int[][] board;
	
	public solver(int[][] board) 
	{
		this.board = new int[9][9];		
		for (int i = 0; i < 9; i++) 
		{
			for (int j = 0; j < 9; j++) 
			{
				this.board[i][j] = board[i][j];
			}
		}
	}
	
	private boolean isInRow(int row, int number) 
	{
		for (int i = 0; i < 9; i++)
		{
			if (board[row][i] == number)
			{
				return true;		
			}
		}
		return false;
	}
	
	private boolean isInCol(int col, int number) {
		for (int i = 0; i < 9; i++)
		{
			if (board[i][col] == number)
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean isInBox(int row, int col, int number) {
		int r = row - row % 3;
		int c = col - col % 3;
		for (int i = r; i < r + 3; i++)
		{
			for (int j = c; j < c + 3; j++)
			{
				if (board[i][j] == number)
				{
					return true;
				}
			}
		}
		return false;
	}
	private boolean isOk(int row, int col, int number) {
		return (!isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number));
	}
	public boolean solve() 
	{
		for (int row = 0; row < 9; row++) 
		{
			for (int col = 0; col < 9; col++) 
			{
				if (board[row][col] == 0) 
				{
					for (int number = 1; number <= 9; number++) {
						if (isOk(row, col, number)) {
							board[row][col] = number;
							if (solve()) {
								return true;
							} 
							else 
							{ // if not a solution, we empty the cell and we continue
								board[row][col] = 0;
							}
						}	
					}
					return false; // we return false
				}
			}
		}
		return true; // sudoku solved
	}
	
	public void display() 
	{
		for (int i = 0; i < 9; i++) 
		{
			for (int j = 0; j < 9; j++) 
			{
				System.out.print(" " + board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void print(int[][]board)
	{
		for (int i = 0; i < 9; i++) 
		{
			for (int j = 0; j < 9; j++) 
			{
				if(board[i][j] == 10)
				{
					System.out.print(" " + '+');
				}
				else
				{
					System.out.print(" " + board[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 9; i++)
		{
			for(int k = 0; k < 9; k++)
			{
				sud[i][k] = scan.nextInt();
				if(sud[i][k] == 0)
				{
					sud[i][k] = 10;
				}
				print(sud);
			}
		}
		for(int i = 0; i < 9; i++)
		{
			for(int k = 0; k < 9; k++)
			{
				if(sud[i][k] == 10)
				{
					sud[i][k] = 0;
				}
			}
		}
		solver sudoku = new solver(sud);
		sudoku.display();
		// we try resolution
		if (sudoku.solve()) {
			sudoku.display();
		} else {
			System.out.println("Unsolvable");
		}
	}
}