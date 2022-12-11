package tp1.p2.control.exceptions;

public class NotCatchablePositionException extends InvalidPositionException {
	
	private static final long serialVersionUID = 1L;

	public NotCatchablePositionException(String message) {
		super(message);
	}

	public NotCatchablePositionException(Throwable cause) {
		super(cause);
	}

	public NotCatchablePositionException(String message, Throwable cause) {
		super(message, cause);
	}

}
