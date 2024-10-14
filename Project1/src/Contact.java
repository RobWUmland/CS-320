//Robert Umland //
//CS320 C-5     //
//Prof Bermudez //

package grandStrandSystems;

import java.util.concurrent.atomic.AtomicInteger;

public class Contact {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private final String contactID; // Unique and not updatable and must be 10 characters or less
    private String firstName; // Cannot be longer than 10 characters, cannot be null
    private String lastName;  // Cannot be longer than 10 characters, cannot be null
    private String number;    // Must be exactly 10 digits, cannot be null
    private String address;   // Must be less than 30 characters, cannot be null

    public Contact(String firstName, String lastName, String number, String address) {
        this.contactID = String.format("%010d", idCounter.incrementAndGet()); // Generates a unique ID
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(number);
        setAddress(address);
    }

    public String getId() {
        return contactID;
    }

    // Getters for other fields
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    // Setters with validation
    public void setFirstName(String fName) {
        if (fName == null || fName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        this.firstName = fName;
    }

    public void setLastName(String lName) {
        if (lName == null || lName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }
        this.lastName = lName;
    }

    public void setPhone(String newNumber) {
        if (newNumber == null || newNumber.length() != 10 || !newNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
        this.number = newNumber;
    }

    public void setAddress(String newAddress) {
        if (newAddress == null || newAddress.length() > 30) {
            throw new IllegalArgumentException("Invalid Address");
        }
        this.address = newAddress;
    }
}

