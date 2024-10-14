//Robert Umland //
//CS320 C-5     //
//Prof Bermudez //

package grandStrandSystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

    private AppointmentService appointmentService;
    private Date futureDate;
    private Date newFutureDate;

    @BeforeEach
    public void setUp() {
        // Initialize the AppointmentService and future dates for tests
        appointmentService = new AppointmentService();
        futureDate = new Date(System.currentTimeMillis() + 86400000L); // 1 day in the future
        newFutureDate = new Date(System.currentTimeMillis() + 172800000L); // 2 days in the future
    }

    //Adding Appointments

    @Test
    public void testAddUniqueAppointment() {
        Appointment appointment = new Appointment(futureDate, "Doctor's appointment");
        appointmentService.addAppointment(appointment);

        // Verify that the appointment was added
        assertNotNull(appointmentService.getAppointment(appointment.getAppointmentID()));
        assertEquals(appointment, appointmentService.getAppointment(appointment.getAppointmentID()));
    }

    @Test
    public void testAddDuplicateAppointmentThrowsException() {
        Appointment appointment1 = new Appointment(futureDate, "Doctor's appointment");
        appointmentService.addAppointment(appointment1);

        // Try to add the same appointment again (with a duplicate ID)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment1);
        });
        assertEquals("Appointment ID already exists.", exception.getMessage());
    }

    //Deleting Appointments

    @Test
    public void testDeleteAppointmentById() {
        Appointment appointment = new Appointment(futureDate, "Dentist appointment");
        appointmentService.addAppointment(appointment);

        // Verify the appointment exists
        assertNotNull(appointmentService.getAppointment(appointment.getAppointmentID()));

        // Delete the appointment
        appointmentService.deleteAppointment(appointment.getAppointmentID());

        // Verify the appointment was deleted
        assertNull(appointmentService.getAppointment(appointment.getAppointmentID()));
    }

    @Test
    public void testDeleteNonExistentAppointmentThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("nonexistentID");
        });
        assertEquals("Appointment ID not found.", exception.getMessage());
    }

    //Updating Appointments

    @Test
    public void testUpdateAppointment() {
        Appointment appointment = new Appointment(futureDate, "Doctor's appointment");
        appointmentService.addAppointment(appointment);

        // Update appointment's date and description
        String newDescription = "Dentist appointment";
        appointmentService.updateAppointment(appointment.getAppointmentID(), newFutureDate, newDescription);

        // Verify updated fields
        assertEquals(newFutureDate, appointment.getAppointmentDate());
        assertEquals(newDescription, appointment.getAppointmentDescription());
    }
}
