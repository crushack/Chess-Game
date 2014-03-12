import java.io.IOException;

import DAL.reader;


public class application {

	public static void main(String[] args) throws IOException {
		System.out.println("BEGIN");
		reader file = new reader("file.txt");
		while ( true ) {
			String line = file.readln();
			if ( line == null ) break;
			System.out.println(line);
		}
	}

}
