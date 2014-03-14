package Objects;

import static org.junit.Assert.*;

import org.junit.Test;

import settings.settings;

public class boardTest {

	@Test
	public void stressTest() {
		
		int i;
		board b = new board(board.initialState());
		for ( i = 0; i < 2400000; ++ i) {
			b.flip();
		}
	}
	
	@Test
	public void stressTestCreation() {
		
		int i;
		for ( i = 0; i < 2400000; ++ i) {
			board b = new board(board.initialState());
		}
	}
	
	@Test
	public void testFlipOperation() {
		
		int count = 0;
		board b = new board(board.initialState());
		
		b.flip();
		
		for ( int i = 0 ; i < settings.BOARD_SIZE; ++ i )
			count += b.map[i].equals(board.initialState()[i]) ? 1 : 0;
	
		if ( count == settings.BOARD_SIZE )
			fail("Wrong operation");
		
		b.flip();
		
		for ( int i = 0 ; i < settings.BOARD_SIZE; ++ i )
			if ( !b.map[i].equals(board.initialState()[i] ))
				fail("Wrong operation");
	}

}
