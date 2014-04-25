package AI_ready;

import java.util.ArrayList;

import Objects.board;
import Objects.move;

public class RandomAi implements brain {

	public RandomAi() {
		
	}
	
	@Override
	public move think(board state, int color) {
		
		ArrayList<move> possibleMoves = state.getPossibleMoves(color);
		move nextMove = possibleMoves.get( (int)(Math.random() * possibleMoves.size()) );
		
		return nextMove;
	}

}
