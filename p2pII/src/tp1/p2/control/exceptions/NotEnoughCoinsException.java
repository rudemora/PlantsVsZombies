package tp1.p2.control.exceptions;

import tp1.p2.view.Messages;

public class NotEnoughCoinsException extends GameException {
	
	private static final long serialVersionUID = 1L;
	
	public NotEnoughCoinsException() {
		super(Messages.NOT_ENOUGH_COINS);
	}

	public NotEnoughCoinsException(String message) {
		super(message);
	}

	public NotEnoughCoinsException(Throwable cause) {
		super(cause);
	}

	public NotEnoughCoinsException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotEnoughCoinsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
