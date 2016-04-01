package org.onlinestore.shoppingcart.exception;

public class EmptyCartException extends RuntimeException {

	private static final long serialVersionUID = 7116001096592215476L;

	public EmptyCartException() {
		super();
	}

	public EmptyCartException(String message) {
		super(message);
	}

}
