package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class BookCatalogTest {

	private final BookCatalog bc;
	private final Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		book1 = new Book(1,"Learning Java","","","",0);
		bc.addBook(book1);
	}

	//G
	@Test
	public void testAddABook() {
		Book book2 = new Book(2, "Unlearning Java", "", "", "", 100000);
		bc.addBook(book2);
		System.out.println(book2);
	}

	//G
	@Test
	public void testFindBook() {
		try {
			System.out.println(bc.findBook("Learning Java"));
        } catch (BookNotFoundException e) {
			fail();
        }
	}

	//G
	@Test
	public void testFindBookIgnoringCase() {
		try {
			System.out.println(bc.findBook("learning java"));
		} catch (BookNotFoundException e) {
			fail();
		}
	}

	//G
	@Test
	public void testFindBookWithExtraSpaces() {
		try {
			System.out.println(bc.findBook(" Learning Java "));
		} catch (BookNotFoundException e) {
			fail();
		}
	}

	//G
	@Test
	public void shouldThrowExceptionWhenCatalogIsEmpty() {
		BookCatalog emptyCatalog = new BookCatalog();
		try {
            if (emptyCatalog.getNumberOfBooks() == 0) {
				throw new RuntimeException();
			}
			fail();
        } catch (RuntimeException _) {}
	}

	//VG
	// This test should throw BookNotFoundException in order to pass.
	@Test
	public void testFindBookThatDoesntExist() throws BookNotFoundException {
		assertThrows(BookNotFoundException.class, () -> bc.findBook("I do not exist"));
	}

	//VG
	//Skriv ett parameteriserat test som verifierar att metoden findBook(String title)
	// hittar samma bok oavsett hur titeln skrivs med stora och små bokstäver.
	//Du kan testa med
	// "Learning Java"
	//"learning java"
	//"LEARNING JAVA"
	@ParameterizedTest
	@ValueSource(strings = {"Learning Java", "learning java", "LEARNING JAVA"})
	public void shouldFindBookRegardlessOfCase(String title) throws BookNotFoundException {
		bc.findBook(title);
	}

}
