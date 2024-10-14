//Robert Umland //
//CS320 C-5     //
//Prof Bermudez //

package grandStrandSystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    private Date futureDate;
    private Date pastDate;

    @BeforeEach
    public void setUp() {
        futureDate = new Date(System.currentTimeMillis() + 86400000L); // 1 day in the future
        pastDate = new Date(System.currentTimeMillis() - 86400000L);   // 1 day in the past
    }

    //Appointment Creation Tests

    @Test
    public void testValidAppointmentCreation() {
        Appointment appointment = new Appointment(futureDate, "Doctor's appointment");

        assertNotNull(appointment.getAppointmentID());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor's appointment", appointment.getAppointmentDescription());
    }

    @Test
    public void testExactly50CharactersDescription() {
        String description50 = "This description is exactly fifty characters long.";

        Appointment appointment = new Appointment(futureDate, description50);

        assertEquals(description50, appointment.getAppointmentDescription());
    }

    //Date Validation Tests

    @Test
    public void testNullAppointmentDateThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, "Doctor's appointment");
        });
        assertEquals("Appointment date cannot be null.", exception.getMessage());
    }

    @Test
    public void testPastAppointmentDateThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(pastDate, "Doctor's appointment");
        });
        assertEquals("Appointment date cannot be in the past.", exception.getMessage());
    }

    @Test
    public void testSetValidAppointmentDate() {
        Appointment appointment = new Appointment(futureDate, "Doctor's appointment");
        Date newFutureDate = new Date(System.currentTimeMillis() + 172800000L); // 2 days in the future

        appointment.setAppointmentDate(newFutureDate);
        assertEquals(newFutureDate, appointment.getAppointmentDate());
    }

    @Test
    public void testSetNullAppointmentDateThrowsException() {
        Appointment appointment = new Appointment(futureDate, "Doctor's appointment");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDate(null);
        });
        assertEquals("Appointment date cannot be null.", exception.getMessage());
    }

    @Test
    public void testSetPastAppointmentDateThrowsException() {
        Appointment appointment = new Appointment(futureDate, "Doctor's appointment");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDate(pastDate);
        });
        assertEquals("Appointment date cannot be in the past.", exception.getMessage());
    }

    //Description Validation Tests

    @Test
    public void testNullAppointmentDescriptionThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(futureDate, null);
        });
        assertEquals("Description must be non-null and up to 50 characters.", exception.getMessage());
    }

    @Test
    public void testLongAppointmentDescriptionThrowsException() {
        String longDescription = "This description is way too long to be accepted by the system.";
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(futureDate, longDescription);
        });
        assertEquals("Description must be non-null and up to 50 characters.", exception.getMessage());
    }

    @Test
    public void testSetValidAppointmentDescription() {
        Appointment appointment = new Appointment(futureDate, "Doctor's appointment");

        String newDescription = "Dentist appointment";
        appointment.setAppointmentDescription(newDescription);

        assertEquals(newDescription, appointment.getAppointmentDescription());
    }

    @Test
    public void testSetNullAppointmentDescriptionThrowsException() {
        Appointment appointment = new Appointment(futureDate, "Doctor's appointment");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDescription(null);
        });
        assertEquals("Description must be non-null and up to 50 characters.", exception.getMessage());
    }

    @Test
    public void testSetLongAppointmentDescriptionThrowsException() {
        Appointment appointment = new Appointment(futureDate, "Doctor's appointment");

        String longDescription = "This description is way too long to be accepted by the system.";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDescription(longDescription);
        });
        assertEquals("Description must be non-null and up to 50 characters.", exception.getMessage());
    }
}
