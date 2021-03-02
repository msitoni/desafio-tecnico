package br.com.sitoni.domain.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	
	/**
	 *
	 */
	private static final long serialVersionUID = -7729034632744518972L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
