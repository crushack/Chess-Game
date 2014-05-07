package settings;

public class settings {
	
	// board.java options
	public static final int BOARD_SIZE = 8;
	public static final char FREE_CHELL = ' ';
	public static final int NO_REMEMBERED_MOVES = 5;
	
	// DAL (Data Access Layer) options
	public static final int FILE_BUFFER_SIZE = 64 * 1024;
	
	// game.java options
	public static final int LAST_GAME = 0;
	public static final int NEW_GAME = 1;
	
	public static final String LOG_FILE = "log.txt";
	
	public static final int MAX_DEPTH = 3;
	public static final int INFINITE = 1000000;
}
