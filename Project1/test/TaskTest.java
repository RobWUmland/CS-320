//Robert Umland //
//CS320 C-5     //
//Prof Bermudez //

package grandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    void testTaskIDIsNotNull() {
        // Create a new Task object
        Task task = new Task("TaskName", "This is a task description.");
        // Verify that the task ID is not null
        assertNotNull(task.getTaskId());
    }

    @Test
    void testTaskIDCannotBeUpdated() {
        // Create a new Task object
        Task task = new Task("TaskName", "This is a task description.");
        String initialId = task.getTaskId();
        
        // Verify it cannot be changed (since no setter exists, it should remain the same)
        assertEquals(initialId, task.getTaskId());
    }

    @Test
    void testTaskNameCannotBeNull() {
        // Attempt to create a Task with a null task name
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "This is a task description.");
        });
        // Verify that the exception message is as expected
        assertEquals("Invalid Task Name", exception.getMessage());
    }

    @Test
    void testTaskNameCannotBeMoreThan20Characters() {
        // Attempt to create a Task with a name longer than 20 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("ThisTaskNameIsWayTooLong", "This is a task description.");
        });
        // Verify that the exception message is as expected
        assertEquals("Invalid Task Name", exception.getMessage());
    }

    @Test
    void testTaskDescriptionCannotBeNull() {
        // Attempt to create a Task with a null description
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("TaskName", null);
        });
        // Verify that the exception message is as expected
        assertEquals("Invalid Task Description", exception.getMessage());
    }

    @Test
    void testTaskDescriptionCannotBeMoreThan50Characters() {
        // Attempt to create a Task with a description longer than 50 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("TaskName", "This description is way too long and exceeds fifty characters.");
        });
        // Verify that the exception message is as expected
        assertEquals("Invalid Task Description", exception.getMessage());
    }
}
