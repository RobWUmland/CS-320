//Robert Umland //
//CS320 C-5     //
//Prof Bermudez //

package grandStrandSystems;

import java.util.HashMap;

public class ContactService {
    // HashMap to store contacts with contactID as the key
    private HashMap<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>(); // Initialize the HashMap
    }

    // Method to add a contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getId())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contact.getId(), contact); // Add the contact to the HashMap
    }

    // Method to delete a contact by contactID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.remove(contactId); // Remove the contact from the HashMap
    }

    // Method to update contact fields based on contactID
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        // Update fields if the new values are not null
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    // Method to retrieve a contact by contactID
    public Contact getContact(String contactId) {
        return contacts.get(contactId); // Return the contact if found, or null if not found
    }
}
