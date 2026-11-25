package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookTest {

	private final Book book1;
	private final Book book1Duplicate;
	private final Book book1SameIdSameTitle;
	private final Book book1SameIdDiffTitle;
	private final Book book2;
	private final Book book2DiffId;

	public BookTest() {
		book1 = new Book(1, "Book 1", "Author 1", "","",1000);
		book1Duplicate = new Book(1, "Book 1", "Author 1", "","",1000);
		book1SameIdSameTitle = new Book(1, "Book 1", "Author 2", "","",2000);
		book1SameIdDiffTitle = new Book(1, "Book 1 diff title", "Author 1", "","",1000);
		book2 = new Book(2, "Book 2", "Author 2", "","",2000);
		book2DiffId = new Book(3, "Book 2", "Author 2", "","",2000);
	}

	//G
	@Test
	public void test2EqualBooks() {
		assertEquals(book1, book1Duplicate);
	}

	//G
	@Test
	public void test2NonEqualBooks() {
		assertNotEquals(book1, book2);
	}

	//G
	@Test
	void booksWithSameIdAndTitleShouldBeEqual() {
		assertEquals(book1, book1SameIdSameTitle);
	}

	//G
	@Test
	void booksWithDifferentIdsShouldNotBeEqual() {
		assertNotEquals(book2, book2DiffId);
	}

	//G
	@Test
	void booksWithSameIdButDifferentTitlesShouldNotBeEqual() {
		assertNotEquals(book1, book1SameIdDiffTitle);
	}
}
