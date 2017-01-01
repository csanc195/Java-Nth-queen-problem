

import java.util.Arrays;
import static java.lang.Math.*;
/**
 * @author CarlosSanchez P_ID:5446178
 * I certify that the following is my work and I did not consult with
 * anyone.
 */

public class Main {

	public static void main(String[] args) {

		int n=8;
		int [] board = Board.nQueens(n);
		System.out.printf("%s %s\n\n","With Board Size: ", n);
		System.out.printf("%s %s\n", "Array board representation: \n", Arrays.toString(board));
		Board.printBoard(board);

	}
}
