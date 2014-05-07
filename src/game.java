import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import AI_ready.brain;
import DAL.stdProtocol;
import Objects.board;
import Objects.move;
import settings.settings;

// game class
// it actually does the communication with the game and the program's tools 

public class game {

	private BufferedReader stdin;
	private board gameBoard;
	
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
	
	private int color; 
	private boolean forced;
	private int numMoves;
	
	private PrintWriter fileLog;
	
	private brain ChessBot;
	
	public game(BufferedReader stdin, brain ChessBot) throws IOException {
		this.stdin = stdin;
		gameBoard = new board(board.initialState());
		fileLog = new PrintWriter(new FileWriter(settings.LOG_FILE,true));
		color = 1;
		forced = false;
		numMoves = 0;
		
		this.ChessBot = ChessBot;
	}
	
	// This command will be sent once immediately after your engine process is started. 
	// You can use it to put your engine into "xboard mode" if that is needed. 
	// If your engine prints a prompt to ask for user input, 
	//	you must turn off the prompt and output a newline when the "xboard" command comes in.
	
	public int eventXBoard( String event ) {
		stdProtocol.message("", fileLog);
		return EVENT_XBOARD;
	}
	
	// Reset the board to the standard chess starting position. 
	// Set White on move. Leave force mode and set the engine to play Black.
	// Associate the engine's clock with Black and the opponent's clock with White. 
	// Reset clocks and time controls to the start of a new game. 
	// Use wall clock for time measurement. Stop clocks. 
	// Do not ponder on this move, even if pondering is on. 
	// Remove any search depth limit previously set by the sd command.
	
	public int eventNew( String event ) {
		gameBoard = new board(board.initialState());
		numMoves = 0;
		return EVENT_NEW;
	}
	
	// Set the engine to play neither color ("force mode"). Stop clocks. 
	// The engine should check that moves received in force mode are legal 
	//   and made in the proper turn, but should not think, ponder, 
	//     or make moves of its own.
	
	public int eventForce( String event ) {
		forced = true;
		return EVENT_FORCE;
	}
	
	// Leave force mode and set the engine to play the color that is on move. 
	// Associate the engine's clock with the color that is on move, 
	// the opponent's clock with the color that is not on move. Start the engine's clock. 
	// Start thinking and eventually make a move.
	
	public int eventGo( String event ) {
		forced = false;
		
		stdProtocol.message("e2e4", fileLog);
		++ numMoves;
		return EVENT_GO;
	}
	
	// Set White on move. Set the engine to play Black. Stop clocks.
	
	public int eventWhite( String event ) {
		color = 0;
		
		move nextMove = ChessBot.think(gameBoard, color);
		stdProtocol.message("move " + nextMove.getMove(), fileLog);
		gameBoard.move(nextMove);
		++ numMoves;
		
		return EVENT_WHITE;
	}
	
	// Set Black on move. Set the engine to play White. Stop clocks.
	
	public int eventBlack( String event ) {
		color = 1;
		return EVENT_BLACK;
	}
	
	// The chess engine should immediately exit. 
	// This command is used when xboard is itself exiting, 
	//   and also between games if the -xreuse command line option is given
	//   (or -xreuse2 for the second engine).
	
	public int eventQuit( String event ) {
		
		return EVENT_QUIT;
	}
	
	// If your engine wants to resign, it can send the command "resign". 
	// Alternatively, it can use the "RESULT {comment}" command 
	// if the string "resign" is included in the comment; for example "0-1 {White resigns}".
	// xboard relays the resignation to the user, the ICS, 
	// the other engine in Two Machines mode, and the PGN save file as required.
	
	public int eventResign( String event ) {
		
		return EVENT_RESIGN;
	}
	
	
	public int eventMove( String event ) {
		
		move nextMove = move.convertOutput(event);
		gameBoard.move(nextMove);
		++ numMoves;
		
		//board.printBoard(gameBoard);
		
		if ( !forced ) {
			nextMove = ChessBot.think(gameBoard, color);
			stdProtocol.message("move " + nextMove.getMove(), fileLog);
			gameBoard.move(nextMove);
			++ numMoves;
		}
		return EVENT_MOVE;
	}
	
	// this method executes the commands read from stdin 
	
	public int eventParse( String event ) {

		if ( event.startsWith("xboard") )
			return eventXBoard(event);
		else if ( event.startsWith("new"))
			return eventNew(event);
		else if ( event.startsWith("force"))
			return eventForce(event);
		else if ( event.startsWith("go"))
			return eventGo(event);
		else if ( event.startsWith("white"))
			return eventWhite(event);
		else if ( event.startsWith("black"))
			return eventBlack(event);
		else if ( event.startsWith("quit"))
			return eventQuit(event);
		else if ( event.startsWith("resign"))
			return eventResign(event);
		else if ( ('a' <= event.charAt(0) && event.charAt(0) <= 'h' &&
				  '1' <= event.charAt(1) && event.charAt(1) <= '8') || 
				   event.charAt(0) == 'O')
			return eventMove(event);
			
		stdProtocol.message("Error (ambiguous move): " + event, fileLog);
		return ERR_WRONG_EVENT;
	}
	
	// game start point
	
	public int run() throws IOException {
		
		int eventCode;
		
		while ( true ) {
			String event = stdProtocol.getMessage(stdin, fileLog);
			eventCode = eventParse(event);
			fileLog.flush();
			if ( eventCode == EVENT_QUIT ) break;
		}
		
		fileLog.close();
		
		stdProtocol.message("Successfull game ending!", fileLog);
		if ( eventCode == EVENT_NEW ) 
			return settings.NEW_GAME;
		return settings.LAST_GAME;
	}
}
