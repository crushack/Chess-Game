import java.io.IOException;
import java.util.ArrayList;

import AI_ready.brainType;
import Objects.board;
import Objects.move;

// starting point of the application, it initializes the bootstrapper

public class application {

	public static void main(String[] args) throws IOException {
		bootstrapper app = new bootstrapper();
		app.run(brainType.RETARDED);
		
		/*board b = new board(board.initialState());
		
		ArrayList<move> possibleMoves = b.getPossibleMoves(1);
		
		for ( move m : possibleMoves ) {
			board nState = new board(b);
			nState.move(m);
			board.printBoard(nState);
		}*/
	}

}
