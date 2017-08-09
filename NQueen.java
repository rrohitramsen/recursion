package com.program.recursion;

public class NQueen {
	
	
	
	public static boolean solve(Board board, int col) {
		if(col >= board.col) {
			return true;
		}else {
			for (int row=0; row<board.row; row++) {
				if (isSafe(board, row, col)) { // check is it safe loc
					placeQueen(board, row, col); // if safe then place the queen n try next col
					if(solve(board, col+1)) { // if it was safe then call next recur with new col
						return true;
					}
					removeQueen(board, row, col);
				}
			}
			return false;
		}
	}
	
	private static void removeQueen(Board board, int row, int col) {
		board.board[row][col] = false;
	}

	private static void placeQueen(Board board, int row, int col) {
		board.board[row][col] = true;
	}

	private static boolean isSafe(Board board, int row, int col) {
		int r=0, c=0;
		
		// horizontal left 
		for(r=row, c=col; c>=0; c--){
			if (board.board[r][c] == true)
				return false;
		}
		
		// horizontal right
		for(r=row, c=col; c <board.col; c++){
			if (board.board[r][c] == true)
				return false;
		}
		
		// vertical left
		for (c=col, r=row; r>=0; r--){
			if (board.board[r][c] == true)
				return false;
		}
		
		//vertical right
		for (c=col, r=row; r<board.row; r++){
			if (board.board[r][c] == true)
				return false;
		}
		
		// diognal above left
		for (c=col, r=row; c>=0 && r>=0; c--, r--){
			if (board.board[r][c] == true)
				return false;
		}
		
		// diognal bottom left
		for (c=col, r=row; c >=0 && r<board.row; r++, c--) {
			if (board.board[r][c] == true)
				return false;
		}
		
		// diognal above right
		for (c=col, r=row; r >=0 && c<board.col; r--, c++) {
			if (board.board[r][c] == true)
				return false;
		}
		
		// diognal bottom right
		for (c=col, r=row; r<board.row && c<board.col; r++, c++) {
			if (board.board[r][c] == true)
				return false;
		}
		
		return true;
	}
	
	public static void displayBoard(Board board){
		System.out.println("********************* ["+board.row+"] ["+board.col+"] QUEEN PROBLEM *****************************");
		for (int r=0; r<board.row; r++ ){
			for (int c=0; c<board.col; c++ ){
				if (board.board[r][c] == true){
					System.out.print("[Q]");
				}else{
					System.out.print("[ ]");
				}
			}
			System.out.println();
		}
	}

	public static class Board {
		
		private boolean board[][];
		private int row;
		private int col;
		private static final int DEFAULT_SIZE=8;
		
		public Board() {
			this(DEFAULT_SIZE,DEFAULT_SIZE);
		}
		public Board(int row, int col) {
			board = new boolean[row][col];
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) {
		Board board = new Board(8,8);
		solve(board, 0);
		displayBoard(board);
	}

}
