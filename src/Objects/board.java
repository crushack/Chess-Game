package Objects;

import settings.settings;
import java.util.ArrayList;

public class board {

	// represents the positioning of the pieces on the board
	// peace type (eg. 'P' pwan, 
	//                 'R' rook, 
	//                 'N' knight, 
	//                 'B' bishop, 
	//                 'Q' queen,
	//                 'K' king
	// uppercase for white peaces and lowercase for black peaces
	
	private char map[][] = new char[settings.BOARD_SIZE][settings.BOARD_SIZE];
	
	// if moved[x][y] = 0 => the piece hasn't been moved
	// else => the piece has been moved 
	
	private boolean moved[][] = new boolean[settings.BOARD_SIZE][settings.BOARD_SIZE];
	
	// a list of the last moves done on the table
	
	move [] lastMoves = new move[settings.NO_REMEMBERED_MOVES];
	
	// @constructor 
	
	public board () {
		
	}
	
	// @constructor 
	// create board from 8x8 char matrix
	
	public board ( char map[][] ) {
		setBoard( map );
	}
	
	// returns all possible moves from current state
	// it uses the helper functions:
	// 		ArrayList<move> getPawnMoves( board b, Point position )
	//		ArrayList<move> getRookMoves( board b, Point position )
	//		ArrayList<move> getKnightMoves( board b, Point position )
	//		ArrayList<move> getBishopMoves( board b, Point position )
	//		ArrayList<move> getQueenMoves( board b, Point position )
	//		ArrayList<move> getKingMoves( board b, Point position )
	
	ArrayList<move> getPossibleMoves() {
		// TODO
		return new ArrayList<move>();
	}
	
	// sets the state of the board custom state $map
	
	void setBoard( char map[][] ) {

		for ( int i = 0; i < settings.BOARD_SIZE; ++ i ) 
			for ( int j = 0; j < settings.BOARD_SIZE; ++ j)
				this.map[i][j] = map[i][j];
		
	}
	
	void clearMoves() {
		
	}
	
}
