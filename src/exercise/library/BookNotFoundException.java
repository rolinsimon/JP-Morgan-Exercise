package exercise.library;

public class BookNotFoundException extends Exception{

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 4237524941638091108L;
	
	public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
