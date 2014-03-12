package DAL;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import settings.settings;
// class supports fast reading actions from files

public class reader {

	private FileInputStream fis;
	private BufferedReader br;
	
	// @constructor
	// initializes the class for reading from the file filename 
	
	public reader( String filename ) throws FileNotFoundException {
		fis = new FileInputStream(filename);
		br = new BufferedReader(new InputStreamReader(fis), settings.FILE_BUFFER_SIZE);
	}
	
	// method returns the next line of the file
	
	public String readln() throws IOException {
		return br.readLine();
	}
	
	// method closes the file
	// if, after the file is closed, the calling reading methods will result in an error 
	
	public void close() throws IOException {
		fis.close();
	}
	
}
