package exercise.library;

public class IsbnInvalidTextException extends Exception{

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = -7581272482016078751L;

	
	public IsbnInvalidTextException(String message) {
        super(message);
    }

    public IsbnInvalidTextException(String message, Throwable throwable) {
        super(message, throwable);
    }

	
}
