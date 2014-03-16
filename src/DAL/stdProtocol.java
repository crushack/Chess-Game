package DAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class stdProtocol {
	
	public static void message( String msg, PrintWriter fileLog ) {
		System.out.println(msg);
		System.out.flush();
		
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DATE, 1);
		
		fileLog.println( "[" + date.getTime() + "]$ " + msg);
	}
	
	public static String getMessage( BufferedReader br, PrintWriter fileLog ) throws IOException {
		String msg = br.readLine();
		
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DATE, 1);
		
		fileLog.println( "[" + date.getTime() + "]# " + msg);
		return msg;
	}
}
