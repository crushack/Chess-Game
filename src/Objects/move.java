package Objects;

import java.awt.Point;

public class move {

	// peace type (eg. 'P' pawn, 
	//                 'R' rook, 
	//                 'N' knight, 
	//                 'B' bishop, 
	//                 'Q' queen,
	//                 'K' king
	// uppercase for white peaces and lowercase for black peaces
	protected char type; 
	
	// start and end positions for the move
	protected Point currentPosition = new Point();
	protected Point destinationPosition = new Point();
	
	protected char promotion = '-';
	// dummy @constructor
	
	public move() {}
	
	// @constructor 
	
	public move( Point source, Point destination ) {
		currentPosition = source;
		destinationPosition = destination;
	}
	
	// @constructor
	
	public move( int startX, int startY, int destX, int destY) {
		currentPosition.x = startX;
		currentPosition.y = startY;
		destinationPosition.x = destX;
		destinationPosition.y = destY;
	}
	
	// @constructor:
	// converts from algebraic notation to move
	// documentation:
	// 		http://en.wikipedia.org/wiki/Algebraic_notation_(chess)
	//   	http://en.wikipedia.org/wiki/Chess_notation
	
	public move( String s ) {
		// TODO: write a constructor to convert from algebraic notation 
	}
	
	// returns the move in Algebraic Notation
	// documentation:
	//		http://en.wikipedia.org/wiki/Algebraic_notation_(chess)
	//		http://en.wikipedia.org/wiki/Chess_notation
	
	public String getMove() {
		String ret = new String();
		
		ret += (char)('a' + currentPosition.y);
		ret += (char)('1' + currentPosition.x);
		ret += (char)('a' + destinationPosition.y);
		ret += (char)('1' + destinationPosition.x);
		return ret;
	}
	
	// sets the source position to ps
	
	public void setSource( Point ps ) {
		currentPosition = ps;
	}
	
	// sets the source position to (x, y)
	
	public void setSource( int x, int y ) {
		currentPosition.x = x;
		currentPosition.y = y;
	}
		
	// sets the destination position to ps
	
	public void setDest( Point ps ) {
		destinationPosition = ps;
	}
	
	// sets the destination position to (x, y)
	
	public void setDest( int x, int y ) {
		destinationPosition.x = x;
		destinationPosition.y = y;
	}
	
	public Point getSource() {
		
		return currentPosition;
	}
	
	public Point getDest() {
		
		return destinationPosition;
	}
	
	// method converts an Algebraic Notation String to a WinBoard String
	//   documentation: http://www.gnu.org/software/xboard/engine-intf.html#8
	
	public static String getOutputMove( String Algmove ) {
		// TODO
		return new String();
	}
	
	// method converts from WinBoard notation to Algebraic Notation
	// documentation:
	//		- move section from:
	//			~ http://www.gnu.org/software/xboard/engine-intf.html#8
	
	public static String getAlgebraicString( String Wbmove ) {
		// TODO
		return new String();
	}
	
	// method validates move written in Algebraic Notation
	// verify if move doesn't violate any of the chess laws
	
	public static boolean isvalid( String s ) {
		// TODO
		return true;
	}
	
	// convert Algebraic Notation string to move
	// documentation:
	// 		http://en.wikipedia.org/wiki/Algebraic_notation_(chess)
	//   	http://en.wikipedia.org/wiki/Chess_notation
	
	public static move convertAlgebraic( String s ) {
		// TODO
		return new move();
	}
	
	// convert WinBoard Notation string to move
	// documentation:
	//		- move section from:
	//			~ http://www.gnu.org/software/xboard/engine-intf.html#8
	
	public static move convertOutput( String s ) {
		move nextMove = new move();
		int index;
		
		for ( index = 0; s.charAt(index) == ' '; ++ index);
		
		// castling move
		if ( s.charAt(index) == 'O' && s.startsWith("O-O-O")) {
			return convertOutput("e1c1");
		} else if ( s.charAt(index) == 'O' ) {
			return convertOutput("e1g1");
		}
		
		nextMove.setSource(s.charAt(index + 1) - '1', s.charAt(index) - 'a'); 
		index += 2;
		
		nextMove.setDest(s.charAt(index + 1) - '1', s.charAt(index) - 'a');
		
		if ( s.charAt(index + 1) == '8' && s.charAt(index - 1) == '7' && 
		    (s.charAt(index + 2) == 'q' || s.charAt(index + 2) == 'n' || 
		     s.charAt(index + 2) == 'r' || s.charAt(index + 2) == 'b' ))
		     nextMove.promotion = s.charAt(index + 2);
		return nextMove;
	}
	
	// translates a move
	// it is the same as seeing the table from the other side
	
	public static move translate( move m ) {
		// TODO
		return new move();
	}
	
}
