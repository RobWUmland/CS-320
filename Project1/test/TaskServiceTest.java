//Robert Umland //
//CS320 C-5     //
//Prof Bermudez //

package grandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        // Initialize a new TaskService instance before each test
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        // Create a new Task object
        Task task = new Task("TaskName", "This is a task description.");
        // Add the task to the service
        taskService.addTask(task);
        // Verify that the task can be retrieved successfully
        assertEquals(task, taskService.getTask(task.getTaskId()));
    }

    @Test
    public void testDeleteTask() {
        // Create and add a Task object
        Task task = new Task("TaskName", "This is a task description.");
        taskService.addTask(task);
        
        // Delete the task by ID
        taskService.deleteTask(task.getTaskId());
        
        // Verify that the task cannot be found afterwards
        assertNull(taskService.getTask(task.getTaskId()));
    }

    @Test
    public void testDeleteNonExistentTask() {
        // Attempt to delete a task that does not exist
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("1");
        });
        
        // Verify that the exception message is as expected
        assertEquals("Task ID not found.", exception.getMessage());
    }

    @Test
    public void testUpdateTaskFields() {
        // Create and add a Task
        Task task = new Task("TaskName", "This is a task description.");
        taskService.addTask(task);
        
        // Update the task's fields
        taskService.updateTask(task.getTaskId(), "NewTaskName", "Updated task description.");
        
        // Retrieve the updated task
        Task updatedTask = taskService.getTask(task.getTaskId());
        // Verify that the fields were updated correctly
        assertEquals("NewTaskName", updatedTask.getTaskName());
        assertEquals("Updated task description.", updatedTask.getTaskDescription());
    }

    @Test
    public void testUpdateNonExistentTask() {
        // Attempt to update a task that does not exist
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask("1", "NewTaskName", "Updated task description.");
        });
        
        // Verify that the exception message is as expected
        assertEquals("Task ID not found.", exception.getMessage());
    }
}
