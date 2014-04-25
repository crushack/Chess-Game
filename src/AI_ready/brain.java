package AI_ready;

import Objects.board;
import Objects.move;

public interface brain {

	public move think( board state, int color );
	
}
