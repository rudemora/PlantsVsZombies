package tp1.p2.control.exceptions;
import tp1.p2.view.Messages;

public class InvalidPositionException extends GameException {
	
	
	private static final long serialVersionUID = 1L;

	public InvalidPositionException(String message) {
		super(message);
	}

	public InvalidPositionException(Throwable cause) {
		super(cause);
	}

	public InvalidPositionException(String message, Throwable cause) {
		super(message, cause);
	}
	public InvalidPositionException(int col, int row) {
		super(Messages.INVALID_POSITION.formatted(col, row));
		
	}
}
