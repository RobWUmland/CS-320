//Robert Umland //
//CS320 C-5     //
//Prof Bermudez //

package grandStrandSystems;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Date;

public class Appointment {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    
    private final String appointmentID; // Unique, not updatable, and must be 10 characters or less
    private Date appointmentDate; // Cannot be in the past, cannot be null
    private String appointmentDescription;  // Cannot be longer than 50 characters, cannot be null

    // Constructor for Appointment
    public Appointment(Date appointmentDate, String appointmentDescription) {
        // Generate unique ID
        this.appointmentID = String.format("%010d", idCounter.incrementAndGet());

        // Validate and set appointment date
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null.");
        }
        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past.");
        }
        this.appointmentDate = appointmentDate;

        // Validate and set description
        if (appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and up to 50 characters.");
        }
        this.appointmentDescription = appointmentDescription;
    }

 // Getter methods
    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    // Setter for appointmentDate 
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null.");
        }
        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past.");
        }
        this.appointmentDate = appointmentDate;
    }

    // Setter for appointmentDescription (allows updating the description)
    public void setAppointmentDescription(String appointmentDescription) {
        if (appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and up to 50 characters.");
        }
        this.appointmentDescription = appointmentDescription;
    }
}
