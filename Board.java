/**
 * @author CarlosSanchez P_ID:5446178
 */

import static java.lang.Math.abs;
/**
 * The following final class contains a family of methods which are used
 * to create a chess board and using backtracking with recursion proceeds
 * to populate it with the greatest amount of queens that can be placed 
 * without them attacking each other. This number N is determined by the 
 * length of any size of the board. For example: a board of size 8 can 
 * contain at most 8 queens placed in on non conflicting positions. 
 * @author CarlosSanchez
 *
 */
public final class Board {
	
	private static boolean found;
	
	/**
	 * The following method uses the Number n as the dimensions of a board
	 * of chess of variable length, and prints a single board representation 
	 * with n queens where each one of the queens is positioned in a way 
	 * where they are not attacking each other
	 * @param n This is the size of the board.
	 * @return The array representation of the two dimensional board which contains 
	 * the correct positions of the queens which do not attack one another. 
	 */
	public static int[] nQueens(int n){
		int[] board = new int[n];

		placeQueens(0, board);
		return board;
	}

	/**
	 * The following method uses an integer array to construct a board
	 * of chess with N queens, where each queen is free from  attacking each 
	 * other. Parameter x is the current queen position and Parameter board is
	 * the array representing the two-dimensional board. 
	 * @param x	The current queen position.
	 * @param board The two Dimensional board.
	 */
	public static void placeQueens(int x, int[] board) {
		int n = board.length;
		for (int i = 0; i < n && !found; i++) {
			if (canPlace(x, i, board)) {
				board[x] = i+1; 
				if (x == n - 1) {
					found = true;
				}else {
					placeQueens(x + 1, board);
				}
			}
		}
	}
	
	/**
	 * The following method uses the current coordinates of the queen which 
	 * is trying to be placed and decides if the current tentative possition 
	 * is free from any other attacking queen.
	 * @param row	The row of the tentative queen.
	 * @param col	The column of the tentative queen.
	 * @param board	The array representation of the two dimensional board.
	 * @return True if the queen can be placed safely (without conflicts with
	 * other queens), and false if it can not.
	 */
	public static boolean canPlace(int row, int col, int[]board) {
		for (int i = 0; i < row; i++) {
			if (((board[i]-1) == col) 
					|| (abs(i - row) == abs((board[i]-1) - col))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * The following method prints the array entered by parameters interpreting it 
	 * as an array representation of a two dimensional chess board, and places
	 * each queen in its respective location.
	 * @param board
	 */
	public static void printBoard(int [] board){
		int n = board.length;
		System.out.println("\nSquare board representation:");
		
		for(int i=1; i<= n; i++){
			for(int j=0; j< n; j++){
				if(board[j] == i){
					System.out.printf("%s", " [Q] ");
				}else{
					System.out.printf("%s", " [.] ");
				}
			}
			System.out.println("\n");
		}
	}
	
}
