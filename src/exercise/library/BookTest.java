package exercise.library;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {
	
	BookRepositoryImpl bri=new BookRepositoryImpl();
	BookServiceImpl bserv=new BookServiceImpl();
	Book book = null;
	String summary="";
	Book bHarry=bri.retrieveBook(bri.getPrefix()+"001");
	Book bGame=bri.retrieveBook(bri.getPrefix()+"002");
	Book bGenius=bri.retrieveBook(bri.getPrefix()+"003");
	String sHarry="[ISBN-001] Harry Potter and the Deathly Hallows - Sorcery and Magic.";
	String sGame="[ISBN-002] The Player of Games - Jernau Morat Gurgeh. The Player of Games. Master of every board, computer and strategy.";
	String sGenius="[ISBN-003] Genius: Richard Feynman and Modern Physics - A brilliant interweaving of Richard Feynman's colourful life and a detailed and accessible account of his theories and experiments.";
		
	
	@Test
	public void testMethod1ISBN001() {
		try {
			book=bserv.retrieveBook("ISBN-001");
			assertSame(bHarry, book);
			assertNotSame(bGame, book);
			assertNotSame(bGenius, book);
		} catch (BookNotFoundException e) {
			assertTrue(false);
		} catch (IsbnInvalidTextException e) {
			assertTrue(false);
		}
	}
	@Test
	public void testMethod1ISBN002() {
		try {
			book=bserv.retrieveBook("ISBN-002");
			assertNotSame(bHarry, book);
			assertSame(bGame, book);
			assertNotSame(bGenius, book);
		} catch (BookNotFoundException e) {
			assertTrue(false);
		} catch (IsbnInvalidTextException e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testMethod1ISBN003() {
		try {
			book=bserv.retrieveBook("ISBN-003");
			assertNotSame(bHarry, book);
			assertNotSame(bGame, book);
			assertSame(bGenius, book);
		} catch (BookNotFoundException e) {
			assertTrue(false);
		} catch (IsbnInvalidTextException e) {
			assertTrue(false);
		}
	}

	@Test
	public void testMethod2ISBN001() {
		try {
			summary=bserv.getBookSummary("ISBN-001");
			assertEquals(sHarry, summary);
			assertNotEquals(sGame, summary);
			assertNotEquals(sGenius, summary);
		} catch (BookNotFoundException e) {
			assertTrue(false);
		} catch (IsbnInvalidTextException e) {
			assertTrue(false);
		}
	}
	@Test
	public void testMethod2ISBN002() {
		try {
			summary=bserv.getBookSummary("ISBN-002");
			assertNotEquals(sHarry, summary);
			assertEquals(sGame, summary);
			assertNotEquals(sGenius, summary);
		} catch (BookNotFoundException e) {
			assertTrue(false);
		} catch (IsbnInvalidTextException e) {
			assertTrue(false);
		}
	}
	@Test
	public void testMethod2ISBN003() {
		try {
			summary=bserv.getBookSummary("ISBN-003");
			assertNotEquals(sHarry, summary);
			assertNotEquals(sGame, summary);
			assertEquals(sGenius, summary);
		} catch (BookNotFoundException e) {
			assertTrue(false);
		} catch (IsbnInvalidTextException e) {
			assertTrue(false);
		}
	}
	
	private void invalidText(String isbn){
		try {
			book=bserv.retrieveBook(isbn);
			assertTrue(false);
		} catch (BookNotFoundException e) {
			assertTrue(false);
		} catch (IsbnInvalidTextException e) {
			assertTrue(true);
		}
	}
	@Test
	public void testInvalidText() {
		invalidText("INVALID-TEXT");
		invalidText("ISBN");
		invalidText("ISBM-001");
		invalidText("isbn-001");
		invalidText("");
	}
	
	private void bookNotFound(String isbn){
		try {
			book=bserv.retrieveBook(isbn);
			assertTrue(false);
		} catch (BookNotFoundException e) {
			assertTrue(true);
		} catch (IsbnInvalidTextException e) {
			assertTrue(false);
		}
	}
	@Test
	public void testbookNotFound() {
		bookNotFound("ISBN-000");
		bookNotFound("ISBN-1");
		bookNotFound("ISBN-005");
	}
	

}
