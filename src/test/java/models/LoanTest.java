package models;

import org.junit.jupiter.api.Test;
import utilities.GenderType;
import utilities.LoanStatus;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanTest {

	private final Loan loan1;
	private final Loan loan2;

    public LoanTest() {
        Customer customer = new Customer("","","","","","", 1, GenderType.UNKNOWN);
        Book book = new Book(1, "Book 1", "Author 1", "", "", 1000);
        Book book2 = new Book(2, "Book 2", "Author 2", "", "", 2000);
		loan1 = new Loan(1, customer, book);
		loan2 = new Loan(2, customer, book2);
		loan2.endLoan();
	}

	//G
	@Test
	public void testDueDate() {
		LocalDate dueDate = LocalDate.now().plusDays(14);
		assertEquals(dueDate, loan1.getDueDate());
   }

	//VG
	@Test
	void newLoanShouldBeCurrent() {
		assertEquals(LoanStatus.CURRENT, loan1.getStatus());
	}
	
	//VG
	@Test
	void endLoanShouldBeHistoric() {
		assertEquals(LoanStatus.HISTORIC, loan2.getStatus());
	}	
}