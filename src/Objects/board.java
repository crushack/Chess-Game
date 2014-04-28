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
	
	protected String [] map = new String[ settings.BOARD_SIZE ];
	
	// if moved[x][y] = 0 => the piece hasn't been moved
	// else => the piece has been moved 
	
	protected boolean moved[][] = new boolean[settings.BOARD_SIZE][settings.BOARD_SIZE];
	
	// a list of the last moves done on the table
	
	protected move [] lastMoves = new move[settings.NO_REMEMBERED_MOVES];
	
	// @constructor 
	
	public board () {
		init();
	}
	
	// @constructor 
	// create board from 8x8 char matrix
	
	public board ( String [] map ) {
		init();
		setBoard( map );
	}
	
	// @constructor
	// duplicates the model board
	
	public board ( board model ) {
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i )
			this.map[i] = new String(model.map[i]);
		
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i )
			for ( int j = 0; j < settings.BOARD_SIZE; ++ j )
				moved[i][j] = model.moved[i][j];
	}
	
	// method initializes the moved structure
	
	private void init() {
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i )
			for ( int j = 0; j < settings.BOARD_SIZE; ++ j)
				moved[i][j] = true;
	}
	
	// returns all possible moves from current state
	// it uses the helper functions:
	// 		ArrayList<move> getPawnMoves( board b, Point position )
	//		ArrayList<move> getRookMoves( board b, Point position )
	//		ArrayList<move> getKnightMoves( board b, Point position )
	//		ArrayList<move> getBishopMoves( board b, Point position )
	//		ArrayList<move> getQueenMoves( board b, Point position )
	//		ArrayList<move> getKingMoves( board b, Point position )
	
	public ArrayList<move> getPossibleMoves( int color ) {
		
		ArrayList<move> possibleMoves = new ArrayList<move>();
		
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i)
			for ( int j = 0; j < settings.BOARD_SIZE; ++ j) {
				char piece = map[i].charAt(j);
				if ( piece == 'P' && ( color == 0 ))
					possibleMoves.addAll(helper.getPawnMoves(map, moved, new Point(i,j)));
				else if ( piece == 'R' && ( color == 0))
					possibleMoves.addAll(helper.getRookMoves(map, moved, new Point(i,j)));
				else if ( piece == 'N' && ( color == 0))
					possibleMoves.addAll(helper.getKnightMoves(map, moved, new Point(i,j)));
				else if ( piece == 'B' && ( color == 0))
					possibleMoves.addAll(helper.getBishopMoves(map, moved, new Point(i,j)));
				else if ( piece == 'Q' && ( color == 0))
					possibleMoves.addAll(helper.getQueenMoves(map, moved, new Point(i,j)));
				else if ( piece == 'K' && ( color == 0))
					possibleMoves.addAll(helper.getKingMoves(map, moved, new Point(i,j)));
				else if ( piece == 'p' && ( color == 1 ))
					possibleMoves.addAll(helper.getPawnMoves(map, moved, new Point(i,j)));
				else if ( piece == 'r' && ( color == 1))
					possibleMoves.addAll(helper.getRookMoves(map, moved, new Point(i,j)));
				else if ( piece == 'n' && ( color == 1))
					possibleMoves.addAll(helper.getKnightMoves(map, moved, new Point(i,j)));
				else if ( piece == 'b' && ( color == 1))
					possibleMoves.addAll(helper.getBishopMoves(map, moved, new Point(i,j)));
				else if ( piece == 'q' && ( color == 1))
					possibleMoves.addAll(helper.getQueenMoves(map, moved, new Point(i,j)));
				else if ( piece == 'k' && ( color == 1))
					possibleMoves.addAll(helper.getKingMoves(map, moved, new Point(i,j)));
			}
		return possibleMoves;
	}
	
	
	// sets the state of the board custom state $map
	
	void setBoard( String [] map ) {

		for ( int i = 0; i < settings.BOARD_SIZE; ++ i ) 
			this.map[i] = map[i];
		
	}
	
	// returns the cararacter at possition (x, y)
	
	public char charAt( int coord_x, int coord_y ) {
		if ( 0 <= coord_x && coord_x < settings.BOARD_SIZE && 
			 0 <= coord_y && coord_y < settings.BOARD_SIZE )
			return map[coord_x].charAt(coord_y);
		return '-';
	}
	
	// Clears all the moves in the vector $lastMOves
	
	void clearMoves() {
		// TODO
	}

	// changes the color of the pieces and flips the board
	// ATENTION: as seeing the board from the opponent's point of view
	
	public void flip() {
		
		// WARNING: This implementation supports optimization as it will be used a lot
		
		char [][] aux = new char [settings.BOARD_SIZE][];
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i)
			aux[i] = map[i].toCharArray();
		
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i)
			for ( int j = 0; j < settings.BOARD_SIZE / 2; ++ j) {
				char temp = aux[i][j];
				aux[i][j] = aux[ settings.BOARD_SIZE - i - 1 ][ settings.BOARD_SIZE - j - 1];
				aux[ settings.BOARD_SIZE - i - 1 ][ settings.BOARD_SIZE - j - 1] = temp;
			}
		
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i)
			for ( int j = 0; j < settings.BOARD_SIZE; ++ j)
				if ( Character.isLowerCase(aux[i][j]) )
					aux[i][j] = Character.toUpperCase(aux[i][j]);
				else
					aux[i][j] = Character.toLowerCase(aux[i][j]);
		
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i)
			map[i] = new String(aux[i]);
	}
	
	// Executes the move $x on the board, !!!without flipping it!!!
	
	public void move( move x ) {
		
		// TODO: add move to last move
		
		Point source = x.getSource();
		Point dest = x.getDest();
		
		char[] line = map[ dest.x ].toCharArray();
		line[ dest.y ] = map[ source.x ].charAt(source.y);
		
		map[ dest.x ] = new String(line);
		
		line = map[ source.x ].toCharArray();
		line[ source.y ] = settings.FREE_CHELL;
		
		map[ source.x ] = new String(line);
		
		moved[ source.x ][ source.y ] = false;
		moved[ source.x ][ source.y ] = false;
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
