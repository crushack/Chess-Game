package Objects;

import settings.settings;

import java.awt.Point;
import java.util.ArrayList;

public class board {

	// represents the positioning of the pieces on the board
	// peace type (eg. 'P' pawn, 
	//                 'R' rook, 
	//                 'N' knight, 
	//                 'B' bishop, 
	//                 'Q' queen,
	//                 'K' king
	// uppercase for white peaces and lowercase for black peaces
	
	String [] map = new String[ settings.BOARD_SIZE ];
	
	// if moved[x][y] = 0 => the piece hasn't been moved
	// else => the piece has been moved 
	
	protected boolean moved[][] = new boolean[settings.BOARD_SIZE][settings.BOARD_SIZE];
	
	// a list of the last moves done on the table
	
	protected move [] lastMoves = new move[settings.NO_REMEMBERED_MOVES];
	
	// @constructor 
	
	public board () {
		
	}
	
	// @constructor 
	// create board from 8x8 char matrix
	
	public board ( String [] map ) {
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
	
	void setBoard( String [] map ) {

		for ( int i = 0; i < settings.BOARD_SIZE; ++ i ) 
			this.map[i] = map[i];
		
	}
	
	// Clears all the moves in the vector $lastMOves
	
	void clearMoves() {
		// TODO
	}

	// changes the color of the pieces and flips the board
	// ATENTION: as seeing the board from the opponent's point of view
	
	public void flip() {
		
		// WARNING: TODO: This implementation supports optimization as it will be used a lot
		
		String temp;
		
		// flipping the board
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i)
			map[i] = new StringBuilder(map[i]).reverse().toString();
		for ( int i = 0; i < settings.BOARD_SIZE / 2; ++ i) {
			temp = map[i];
			map[i] = map[ settings.BOARD_SIZE - i - 1];
			map[ settings.BOARD_SIZE - i - 1] = temp;
		}
		
		// flipping pieces case
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i) {
			char[] line = map[i].toCharArray();
			for ( int j = 0; j < settings.BOARD_SIZE; ++ j)
				if ( Character.isLowerCase(line[j]) )
						line[j] = Character.toUpperCase(line[j]);
				else 
						line[j] = Character.toLowerCase(line[j]);
			map[i] = new String(line);
		}
	}
	
	// Executes the move $x on the board, !!!without flipping it!!!
	
	public void move( move x ) {
		// TODO
		
		Point source = x.getSource();
		Point dest = x.getDest();
		
		//System.out.println(source.toString());
		//System.out.println(dest.toString());
		
		char[] line = map[ dest.x ].toCharArray();
		line[ dest.y ] = map[ source.x ].charAt(source.y);
		
		map[ dest.x ] = new String(line);
		
		line = map[ source.x ].toCharArray();
		line[ source.y ] = settings.FREE_CHELL;
		
		map[ source.x ] = new String(line);
	}
	
	public static String[] initialState() {
		String [] map = new String[settings.BOARD_SIZE];
		
		map[0] = "RNBQKBNR";
		map[1] = "PPPPPPPP";
		map[2] = "        ";
		map[3] = "        ";
		map[4] = "        ";
		map[5] = "        ";
		map[6] = "pppppppp";
		map[7] = "rnbqkbnr";
		
		return map;
	}
	
	public static void printBoardReverse( board b ) {
		
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i)
			System.out.println(b.map[i]);
	}
	
	public static void printBoard( board b ) {
		
		for ( int i = settings.BOARD_SIZE - 1; i >= 0; -- i)
			System.out.println(b.map[i]);
	}
}
