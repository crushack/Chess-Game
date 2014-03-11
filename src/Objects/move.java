package Objects;

import java.awt.Point;

public class move {

	// peace type (eg. 'P' pwan, 
	//				   'R' rook, 
	//                 'N' knight, 
	//                 'B' bishop, 
	//                 'Q' queen,
	//                 'K' king
	// uppercase for white peaces and lowercase for black peaces
	private char type; 
	
	// start and end positions for the move
	private Point currentPosition = new Point();
	private Point destinationPosition = new Point();
	
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
	// 		http://en.wikipedia.org/wiki/Algebraic_notation_(chess)
	//   	http://en.wikipedia.org/wiki/Chess_notation
	
	public String getMove( board b ) {
		// TODO
		return new String();
	}
}
