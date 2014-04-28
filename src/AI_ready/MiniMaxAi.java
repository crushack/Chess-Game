package AI_ready;

import java.util.ArrayList;

import Objects.board;
import Objects.move;
import settings.settings;

public class MiniMaxAi implements brain {

	private move nextMove;
	
	private static int dumb_heuristic( board state, int color ) {
		int ret;
		
		ret = 1000 * (state.getPossibleMoves(color).size() - state.getPossibleMoves(1 - color).size());
		ret += 10 * Math.random();
		
		return ret;
	}
	
	private int mini( int depth, board state, int color ) {
		if ( depth <= 0 ) return - dumb_heuristic(state, color);
		
		int ret = settings.INFINITE, val;
		ArrayList<move> possibleMoves = state.getPossibleMoves(color);
		
		for ( move m : possibleMoves ) {
			
			board nState = new board(state);
			nState.move(m);
			val = maxi( depth - 1, nState, 1 - color );
			ret = Math.min(ret, val);
		}
		
		return ret;
	}
	
	private int maxi( int depth, board state, int color ) {
		
		if ( depth <= 0 ) return dumb_heuristic(state, color);
		
		int ret = - settings.INFINITE, val;
		ArrayList<move> possibleMoves = state.getPossibleMoves(color);
		
		for ( move m : possibleMoves ) {
			
			board nState = new board(state);
			nState.move(m);
			val = mini( depth - 1, nState, 1 - color );
			ret = Math.max(ret, val);
			if ( depth == settings.MAX_DEPTH && ret == val )
				nextMove = m;
		}
		
		return ret;
	}
	
	@Override
	public move think(board state, int color) {
		
		nextMove = null;
		maxi( settings.MAX_DEPTH, state, color);
		return nextMove;
	}

}
