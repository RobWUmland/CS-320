//Robert Umland //
//CS320 C-5     //
//Prof Bermudez //

package grandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        // Initialize a new ContactService instance before each test
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        // Create a new Contact object
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Elm St");
        // Add the contact to the service
        contactService.addContact(contact);
        // Verify that the contact can be retrieved successfully
        assertEquals(contact, contactService.getContact(contact.getId()));
    }
 
    @Test
    public void testDeleteContact() {
        // Create and add a Contact object
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Elm St");
        contactService.addContact(contact);
        
        // Delete the contact by ID
        contactService.deleteContact(contact.getId());
        
        // Verify that the contact cannot be found afterwards
        assertNull(contactService.getContact(contact.getId()));
    }

    @Test
    public void testDeleteNonExistentContact() {
        // Attempt to delete a contact that does not exist
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("1");
        });
        
        // Verify that the exception message is as expected
        assertEquals("Contact ID not found.", exception.getMessage());
    }

    @Test
    public void testUpdateContactFields() {
        // Create and add a Contact
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Elm St");
        contactService.addContact(contact);
        
        // Update the contact's fields
        contactService.updateContact(contact.getId(), "Jane", "Doe", "0987654321", "456 Oak St");
        
        // Retrieve the updated contact
        Contact updatedContact = contactService.getContact(contact.getId());
        // Verify that the fields were updated correctly
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName()); // Last name should remain the same
        assertEquals("0987654321", updatedContact.getPhone()); // Phone should be updated
        assertEquals("456 Oak St", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        // Attempt to update a contact that does not exist
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1", "Jane", "Doe", "0987654321", "456 Oak St");
        });
        
        // Verify that the exception message is as expected
        assertEquals("Contact ID not found.", exception.getMessage());
    }
}
