package exercise.library;


public class BookServiceImpl implements BookService{
	BookRepositoryImpl bookReposit;
	
	public BookServiceImpl(){
		bookReposit=new BookRepositoryImpl();		
	}
	
    public Book retrieveBook(String isbn) throws BookNotFoundException,IsbnInvalidTextException{
    	Book retrievedBook=null;
		checkPrefix(isbn);
		if( (retrievedBook=bookReposit.retrieveBook(isbn)) ==null){
			throw new BookNotFoundException("This reference doesn't exist");
		}
    	return retrievedBook;
    }
    
    public String getBookSummary(String isbn) throws BookNotFoundException,IsbnInvalidTextException{
    	Book retrievedBook=retrieveBook(isbn);
    	return "["+retrievedBook.getIsbn()+"] "+ retrievedBook.getTitle() +" - "+retrievedBook.getDescription();
    }    
    
    private void checkPrefix(String isbn) throws IsbnInvalidTextException{
    	String prefix=bookReposit.getPrefix();
    	
    	if(isbn.length()<prefix.length() || isbn.substring(0, prefix.length()).compareTo(prefix)!=0){
    		throw new IsbnInvalidTextException("ISBN must begin with : '"
    				+prefix+"'");
    	}
    }
}
