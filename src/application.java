import java.io.IOException;

import AI_ready.brainType;

// starting point of the application, it initializes the bootstrapper

public class application {

	public static void main(String[] args) throws IOException {
		bootstrapper app = new bootstrapper();
		app.run(brainType.RETARDED);
	}

}
