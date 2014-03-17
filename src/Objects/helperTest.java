package Objects;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class helperTest {

	public static String [] midGameMap_1 = {
		"        ",
		"qPP KP P",
		"      P ",
		"   N   Q",
		"    p N ",
		"p  P    ",
		" p    p ",
		"r b   k ",
	};
	
	@Test
	public void getPawnMoves() {
	
		board b =  new board(midGameMap_1);
		
		ArrayList<move> list = helper.getPawnMoves(b.map, b.moved, new Point(1,2));
		
		System.out.println("-- Pawn --");
		for ( move next : list ) {
			System.out.println(next.getSource() + " " + next.getDest());
		}
	}
	
	@Test
	public void getQueenMoves() {
		
		board b =  new board(midGameMap_1);
		
		ArrayList<move> list = helper.getQueenMoves(b.map, b.moved, new Point(3,7));
		
		System.out.println("-- Queen --");
		for ( move next : list ) {
			System.out.println(next.getSource() + " " + next.getDest());
		}
	}

}
