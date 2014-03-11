package Objects;

import java.awt.Point;
import java.util.ArrayList;

// a set of functions that help determine the next moves on a specific
// board
//
// PAY ATTENTION TO THE FOLLOWING: 
//		- a piece can't move if, after it has moved, the king is under attack
//		- a pawn can move to the left or to the right if it attacks
//		- try to use direction vectors for the knight and king
//		- check if king can castle ( it hasn't moved, it isn't under attack and
//				no peace controls any square on it's path )
//		- you must implement the moves for the black and the white pieces
//		- in DEBUGGING STATE, use the move.isValid( move ) function
// 		- please validate that there is actually that piece at the position pos

public class helper {
	
	// returns a list of valid moves for a pawn in position pos
	
	public static ArrayList<move> getPawnMoves( board b, Point pos ) {
		// TODO
		
		// visibility test ( erase it when implementing method )
		b.map[0][0] = 'a';
		b.moved[0][0] = true;
		return new ArrayList<move>();
	}
	
	// returns a list of valid moves for a rook in position pos
	
	public static ArrayList<move> getRookMoves( board b, Point pos ) {
		// TODO
		return new ArrayList<move>();
	}
	
	// returns a list of valid moves for a knight in position pos
	
	public static ArrayList<move> getKnightMoves( board b, Point pos ) {
		// TODO
		return new ArrayList<move>();
	}
	
	// returns a list of valid moves for a bishop in position pos
	
	public static ArrayList<move> getBishopMoves( board b, Point pos ) {
		// TODO
		return new ArrayList<move>();
	}
	
	// returns a list of valid moves for a queen in position pos
	
	public static ArrayList<move> getQueenMoves( board b, Point pos ) {
		// TODO
		return new ArrayList<move>();
	}
	
	// returns a list of valid moves for a king in position pos
	
	public static ArrayList<move> getKingMoves( board b, Point pos) {
		// TODO
		return new ArrayList<move>();
	}
}
