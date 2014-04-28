package AI_ready;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Objects.board;
import Objects.move;
import settings.settings;

public class GreedyAi implements brain {
	
	@Override
	public move think( board state, int color ) {
		
		move best = null;
		ArrayList<move> possibleMoves = state.getPossibleMoves(color);
		Collections.shuffle(possibleMoves, new Random(System.nanoTime()));
		
		for ( move mv : possibleMoves ) {
			Point dest = mv.getDest();
			if ( best == null || state.charAt(dest.x, dest.y) != settings.FREE_CHELL )
				best = mv;
		}
		
		return best;
	}

}
