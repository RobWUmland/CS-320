package grandStrandSystems;

import java.util.Date;
import java.util.HashMap;

public class AppointmentService {
    // HashMap to store appointments with appointmentID as the key
    private HashMap<String, Appointment> appointments;

    public AppointmentService() {
        appointments = new HashMap<>(); // Initialize the HashMap
    }

    // Method to add an appointment
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }
        appointments.put(appointment.getAppointmentID(), appointment); // Add the appointment to the HashMap
    }

    // Method to delete an appointment by appointmentID
    public void deleteAppointment(String appointmentID) {
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID not found.");
        }
        appointments.remove(appointmentID); // Remove the appointment from the HashMap
    }

    // Method to update appointment fields based on appointmentID (except appointmentID itself)
    public void updateAppointment(String appointmentID, Date appointmentDate, String appointmentDescription) {
        Appointment appointment = appointments.get(appointmentID);
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment ID not found.");
        }
        // Update the appointment date if the new value is not null and is not in the past
        if (appointmentDate != null && !appointmentDate.before(new Date())) {
            appointment.setAppointmentDate(appointmentDate);
        } else if (appointmentDate != null) {
            throw new IllegalArgumentException("Appointment date cannot be in the past.");
        }
        
        // Update description if valid
        if (appointmentDescription != null && appointmentDescription.length() <= 50) {
            appointment.setAppointmentDescription(appointmentDescription);
        } else if (appointmentDescription != null) {
            throw new IllegalArgumentException("Description must be non-null and up to 50 characters.");
        }
    }

    // Method to retrieve an appointment by appointmentID
    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID); // Return the appointment if found, or null if not found
    }
}
