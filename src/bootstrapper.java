import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import settings.settings;

// bootstrapper class
// it initializes the environment of the application:
//		- starts the game engine
//		- opens the files and initializes the file readers/writers
//		- evaluates the online settings ( like a list of preprocessed positions )

public class bootstrapper {

	private BufferedReader br;
	
	public bootstrapper () {
		br = new BufferedReader( new InputStreamReader(System.in));
	}
	
	public int startGame() throws IOException {
		game current = new game(br);
		return current.run();
	}
	
	public void run() throws IOException {
		
		while ( startGame() == settings.NEW_GAME ) {
			
		}
	}
	
}
