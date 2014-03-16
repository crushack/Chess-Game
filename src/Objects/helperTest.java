package Objects;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class helperTest {

	@Test
	public void getPawnMoves() {
	
		board b =  new board(board.initialState());
		
		ArrayList<move> list = helper.getPawnMoves(b.map, b.moved, new Point(1,2));
		
		for ( move next : list ) {
			System.out.println(next.getSource() + " " + next.getDest());
		}
	}
	
	@Test
	public void getQueenMoves() {
		
		board b =  new board(board.initialState());
		
		ArrayList<move> list = helper.getQueenMoves(b.map, b.moved, new Point(1,2));
		
		for ( move next : list ) {
			System.out.println(next.getSource() + " " + next.getDest());
		}
	}

}
