package models;

import org.junit.jupiter.api.Test;
import utilities.GenderType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    private final Customer customer;

    public CustomerTest() {
        customer = new Customer("Lord", "Martin", "Thölin","","","", 1, GenderType.MALE);
    }

    //G
    @Test
    void testGetGender() {
        assertEquals(GenderType.MALE, customer.getGender());
    }

    //G
    @Test
    void testGetMailingName() {
        assertEquals("Lord M Thölin", customer.getMailingName());
    }

}
