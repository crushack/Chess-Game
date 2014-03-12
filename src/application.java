import java.io.IOException;

// starting point of the application, it initializes the bootstrapper

public class application {

	public static void main(String[] args) throws IOException {
		bootstrapper app = new bootstrapper();
		app.run();
	}

}
