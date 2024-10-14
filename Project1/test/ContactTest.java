//Robert Umland //
//CS320 C-5     //
//Prof Bermudez //

package grandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

   /*@Test
    void testContactIDIsNotNull() {
        // Create a new Contact object
        Contact contact = new Contact("Bob", "Umland", "1234567890", "103 County St");
        // Verify that the contact ID is not null
        assertNotNull(contact.getId());
    }*/
	
	@Test
	void testValidContactCreation() {
	    // Test the full constructor with valid inputs to ensure all fields are set correctly
	    Contact contact = new Contact("Bob", "Umland", "1234567890", "103 County St");
	    assertEquals("Bob", contact.getFirstName());
	    assertEquals("Umland", contact.getLastName());
	    assertEquals("1234567890", contact.getPhone());
	    assertEquals("103 County St", contact.getAddress());
	    assertNotNull(contact.getId()); // Ensure ID is not null
	}
	
    @Test
    void testContactIDCannotBeUpdated() {
        // Create a new Contact object
        Contact contact = new Contact("Bob", "Umland", "1234567890", "103 County St");
        String initialId = contact.getId();
        
        // There is no setter for contactID, so we verify it cannot be changed
        assertEquals(initialId, contact.getId());
    }

    /*@Test
    void testFirstNameCannotBeNull() {
        // Attempt to create a Contact with a null first name
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        new Contact(null, "Umland", "1234567890", "103 County St");
        });
        // Verify that the exception message is as expected
        assertEquals("Invalid First Name", exception.getMessage());
    }*/
    
    /*@Test
    void testSetFirstNameWithNull() {
        // Step 1: Create a valid Contact object with valid parameters
        Contact contact = new Contact("Bob", "Umland", "1234567890", "103 County St");

        // Step 2: Test the first name setter with an invalid input (null)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);  // This should throw an exception for null first name
        });

        assertEquals("Invalid First Name", exception.getMessage());
    }*/
    
    
    @Test
    void testSetFirstNameWithNullUsingTryCatch() {
        // Create a valid Contact object
        Contact contact = new Contact("Bob", "Umland", "1234567890", "103 County St");

        try {
            // Call the setter directly with null, testing the first branch (fName == null)
            contact.setFirstName(null);  // This should trigger the exception
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Ensure the correct exception message is returned
            assertEquals("Invalid First Name", e.getMessage());
        }
    }
    
    
    
    
    

    @Test
    void testFirstNameCannotBeMoreThan10Characters() {
        // Attempt to create a Contact with a first name longer than 10 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("RobertWilliam", "Umland", "1234567890", "103 County St");
        });
        // Verify that the exception message is as expected
        assertEquals("Invalid First Name", exception.getMessage());
    }

    @Test
    void testLastNameCannotBeNull() {
        // Attempt to create a Contact with a null last name
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Bob", null, "1234567890", "103 County St");
        });
        // Verify that the exception message is as expected
        assertEquals("Invalid Last Name", exception.getMessage());
    }

    @Test
    void testLastNameCannotBeMoreThan10Characters() {
        // Attempt to create a Contact with a last name longer than 10 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Bob", "WilliamUmland", "1234567890", "103 County St");
        });
        // Verify that the exception message is as expected
        assertEquals("Invalid Last Name", exception.getMessage());
    }

    @Test
    void testPhoneNumberCannotBeNull() {
        // Attempt to create a Contact with a null phone number
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Bob", "Umland", null, "103 County St");
        });
        // Verify that the exception message is as expected
        assertEquals("Invalid Phone Number", exception.getMessage());
    }

    @Test
    void testPhoneNumberMustBeExactly10Digits() {
        // Attempt to create a Contact with a phone number that is not exactly 10 digits
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Bob", "Umland", "123456789", "103 County St");
        });
        // Verify that the exception message is as expected
        assertEquals("Invalid Phone Number", exception.getMessage());
    }

    @Test
    void testPhoneNumberCannotContainNonDigits() {
        // Attempt to create a Contact with a phone number that contains non-digit characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Bob", "Umland", "1234567abc", "103 County St");
        });
        // Verify that the exception message is as expected
        assertEquals("Invalid Phone Number", exception.getMessage());
    }

    @Test
    void testAddressCannotBeNull() {
        // Attempt to create a Contact with a null address
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Bob", "Umland", "1234567890", null);
        });
        // Verify that the exception message is as expected
        assertEquals("Invalid Address", exception.getMessage());
    }

    @Test
    void testAddressCannotBeMoreThan30Characters() {
        // Attempt to create a Contact with an address longer than 30 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Bob", "Umland", "1234567890", "This address is way too long and exceeds thirty characters");
        });
        // Verify that the exception message is as expected
        assertEquals("Invalid Address", exception.getMessage());
    }
}
