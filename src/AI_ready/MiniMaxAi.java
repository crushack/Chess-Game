package AI_ready;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Objects.board;
import Objects.helper;
import Objects.move;
import settings.settings;

public class MiniMaxAi implements brain {

	private static final int pawn_score = 1;
	private static final int knight_score = 41;
	private static final int bishop_score = 57;
	private static final int rook_score = 501;
	private static final int queen_score = 997;
	private static final int king_score = 1500;
	
	
	private static final int pawn_multiplier = 1;
	private static final int knight_multiplier = 3;
	private static final int bishop_multiplier = 3;
	private static final int rook_multiplier = 5;
	private static final int queen_multiplier = 9;
	private static final int king_multiplier = 200;
	
	private move nextMove;
	
	private static int dumb_heuristic( board state, int color ) {
		int ret;
		
		ret = 1000 * (state.getPossibleMoves(color).size() - state.getPossibleMoves(1 - color).size());
		ret += 10 * Math.random();
		
		
		return ret;
	}
	
	private static int medium_heuristic( board state, int color ) {
		
		int ret = 0;
		
		int score[] = new int[settings.BOARD_SIZE];
		int player1[][] = new int[settings.BOARD_SIZE][settings.BOARD_SIZE], 
			player2[][] = new int[settings.BOARD_SIZE][settings.BOARD_SIZE];
		
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i)
			score [i] = 0;
		
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i )
			for ( int j = 0; j < settings.BOARD_SIZE; ++ j )
				player1[i][j] = player2[i][j] = 0;
		
		ArrayList<move> pl1 = state.getPossibleMoves(color);
		ArrayList<move> pl2 = state.getPossibleMoves(1 - color);
		
		for ( move m : pl1 )
			++ player1[ m.getDest().x ][ m.getDest().y ];
		
		for ( move m : pl2 )
			++ player2[ m.getDest().x ][ m.getDest().y ];
		
		for ( int i = 0; i < settings.BOARD_SIZE; ++ i)
			for ( int j = 0; j < settings.BOARD_SIZE; ++ j) {
				if ( state.charAt(i, j) == 'p')
					++ score[0];
				if ( state.charAt(i, j) == 'b' ) 
					++ score[1];
				if ( state.charAt(i, j) == 'n' )
					++ score[2];
				if ( state.charAt(i, j) == 'r' )
					++ score[3];
				if ( state.charAt(i, j) == 'q' )
					++ score[4];
				if ( state.charAt(i, j) == 'k' )
					++ score[5];
				if ( state.charAt(i, j) == 'P')
					-- score[0];
				if ( state.charAt(i, j) == 'B' ) 
					-- score[1];
				if ( state.charAt(i, j) == 'N' )
					-- score[2];
				if ( state.charAt(i, j) == 'R' )
					-- score[3];
				if ( state.charAt(i, j) == 'Q' )
					-- score[4];
				if ( state.charAt(i, j) == 'K' )
					-- score[5];
			}
		
		if ( color == 1 ) {
			for ( int i = 0; i < 6; ++ i )
				score[i] = - score [i];
		}
		
		ret += score[0] * pawn_score;
		ret += score[1] * bishop_score;
		ret += score[2] * knight_score;
		ret += score[3] * rook_score;
		ret += score[4] * queen_score;
		ret += score[5] * king_score;
		
		ret = ret * 10 + ( pl1.size() - pl2.size() );
		
		ret = ret * 10 + (int)Math.random() % 100;
		
		return ret;
	}
	
	private int mini( int depth, board state, int color ) {
		if ( depth <= 0 ) return - dumb_heuristic(state, color);
		
		int ret = settings.INFINITE, val;
		ArrayList<move> possibleMoves = state.getPossibleMoves(color);
		Collections.shuffle(possibleMoves, new Random(System.nanoTime()));
		
		for ( move m : possibleMoves ) {
			
			board nState = new board(state);
			nState.move(m);
			
			if ( helper.isCheck(nState, color) )
				continue;
			
			val = maxi( depth - 1, nState, 1 - color );
			ret = Math.min(ret, val);
		}
		
		return ret;
	}
	
	private int maxi( int depth, board state, int color ) {
		
		if ( depth <= 0 ) return dumb_heuristic(state, color);
		
		int ret = - settings.INFINITE, val;
		ArrayList<move> possibleMoves = state.getPossibleMoves(color);
		Collections.shuffle(possibleMoves, new Random(System.nanoTime()));
		
		for ( move m : possibleMoves ) {
			
			board nState = new board(state);
			nState.move(m);
			
			if ( helper.isCheck(nState, color) )
				continue;
			
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
