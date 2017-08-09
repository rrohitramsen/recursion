package com.program.recursion;

public class SudokuSolver {
	
	private static int row;
	private static int col;
	@SuppressWarnings("null")
	public static boolean solver(Board board) {
		int localRow, localCol; 
		if ( !findUnassignedLocation(board)) { //, row, col)) { // base case to get value by refernce like I have to create to static class level variable in SudokuSolver row and col
			return true;
		}
		localRow = row; localCol = col;
		for(int num=1; num<=9; num++) { // recursion case try out all choices
			if (isSafe(board, localRow, localCol, num)) {
				board.board[localRow][localCol]=num; // PlaceNumber(board, row, col, num)
				if (solver(board)){
					return true;
				}
				board.board[localRow][localCol]=0; //RemoveNumber(board, row, col, num)
			}
		}
		return false;
	}
	
	private static boolean isSafe(Board board, Integer row, Integer col, int num) {
		int r, c;
		// check in all rows for the given col
		for (r=0, c=col; r<9; r++){
			if (board.board[r][c] == num)
				return false;
		}
		
		// check in all cols for the given row
		for (c=0, r=row; c<9; c++){
			if (board.board[r][c] == num)
				return false;
		}
		
		//check in the block, how to find the block
		/*
		 * If we look at the block each block as a single block, then entire sudoku block will be like 3 * 3 matrix of 9 blocks
		 * of nine blocks.
		 * row of block = board.row/3    this tells which block in 3*3 matrix
		 * col of block = board.col/3
		 * eg: if in given board, (8,5) we need to filled with num=8. then to verify that its not repeated in its block 
		 * bloackRow = 8/3 = 2;
		 * bloackCol = 5/3 = 1;
		 * hence (8,5) is in (2,1) block means in 3*2 +1 = 7th block starting from 0
		 * Now we need to check all nine elements in this block(3*3 matrix).
		 * [3*blockRow+r] [3*blockCol+c] we get the exact location in board(9*9 matrix)
		 */
		int blockRow = row/3;
		int blockCol = col/3;
		for (r=0; r<3; r++) {
			for (c=0; c<3; c++){
				if (board.board[3*blockRow+r][3*blockCol+c] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void displayBoard(Board board){
		for (int r=0; r<board.row; r++){
			for (int c=0; c<board.col; c++){
				System.out.print("["+board.board[r][c]+"]");
			}
			System.out.println();
		}
	}

	private static boolean findUnassignedLocation(Board board) { //), Integer row,	Integer col) {
		
		for (int r=0; r<9; r++) {
			for (int c=0; c<9; c++) {
				if(board.board[r][c]==0){
					row = r;
					col = c;
					return true;
				}
			}
		}
		return false;
	}

	public static class Board{
		private int board[][];
		private int row;
		private int col;
		
		public Board(){
			this(9,9);
		}
		
		public Board(int row, int col){
			board = new int [row][col];
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) {
		Board board = new Board(9, 9);
		board.board[0][8]=2;
		board.board[1][3]=9;
		board.board[5][3]=8;
		board.board[6][5]=7;
		board.board[7][1]=1;
		board.board[8][4]=6;
		board.board[2][6]=4;
		solver(board);
		displayBoard(board);
	}

}
