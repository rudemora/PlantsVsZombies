package tp1.p2.control.exceptions;

import tp1.p2.view.Messages;

public class NotCatchablePositionException extends InvalidPositionException {
	
	private static final long serialVersionUID = 1L;

	public NotCatchablePositionException(String message) {
		super(message);
	}

	public NotCatchablePositionException(Throwable cause) {
		super(cause);
	}

	public NotCatchablePositionException(int col, int row) {
		super(Messages.NO_CATCHABLE_IN_POSITION.formatted(col,row));
	}

	
	public NotCatchablePositionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
