import java.io.BufferedReader;
import java.io.IOException;

import Objects.board;
import settings.settings;

// game class
// it actually does the communication with the game and the program's tools 

public class game {

	private BufferedReader stdin;
	private board b;
	
	private static final int ERR_WRONG_EVENT = -1;
	
	private static final int EVENT_XBOARD = 1;
	private static final int EVENT_NEW = 2;
	private static final int EVENT_FORCE = 3;
	private static final int EVENT_GO = 4;
	private static final int EVENT_WHITE = 5;
	private static final int EVENT_BLACK = 6;
	private static final int EVENT_QUIT = 7;
	private static final int EVENT_RESIGN = 8;
	private static final int EVENT_MOVE = 9;
	
	public game(BufferedReader stdin) {
		this.stdin = stdin;
		b = new board();
	}
	
	// this method executes the commands read from stdin and then executes them
	
	
	public int eventParse( String event ) {
		
		if ( event.startsWith("xboard") ) {
			// TODO: actually resolve event
			return EVENT_XBOARD;
		} else if ( event.startsWith("new")) {
			// TODO: actually resolve event
			return EVENT_NEW;
		} else if ( event.startsWith("force")) {
			// TODO: actually resolve event
			return EVENT_FORCE;
		} else if ( event.startsWith("go")) {
			// TODO: actually resolve event
			return EVENT_GO;
		} else if ( event.startsWith("white")) {
			// TODO: actually resolve event
			return EVENT_WHITE;
		} else if ( event.startsWith("black")) {
			// TODO: actually resolve event
			return EVENT_BLACK;
		} else if ( event.startsWith("quit")) {
			// TODO: actually resolve event
			return EVENT_QUIT;
		} else if ( event.startsWith("resign")) {
			// TODO: actually resolve event
			return EVENT_RESIGN;
		} else if ( event.startsWith("move")) {
			// TODO: actually resolve event
			return EVENT_MOVE;
		}
		
		return ERR_WRONG_EVENT;
	}
	
	// game start point
	
	public int run() throws IOException {
		
		int eventCode;
		
		while ( true ) {
			String event = stdin.readLine();
			eventCode = eventParse(event);
			if ( eventCode == EVENT_QUIT || eventCode == EVENT_NEW ) break;
		}
		
		if ( eventCode == EVENT_NEW ) 
			return settings.NEW_GAME;
		return settings.LAST_GAME;
	}
}
