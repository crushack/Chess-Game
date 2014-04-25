package AI_ready;

import java.util.ArrayList;

import Objects.board;
import Objects.move;

public class GreedyAi implements brain {

	private move nextMove;
	
	@Override
	public move think( board state, int color ) {
		
		ArrayList<move> possibleMoves = state.getPossibleMoves(color);
		
		// TODO: actually think something
		
		return null;
	}

}
