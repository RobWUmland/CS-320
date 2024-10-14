//Robert Umland //
//CS320 C-5     //
//Prof Bermudez //

package grandStrandSystems;

import java.util.HashMap;

public class TaskService {
    // HashMap to store tasks with taskID as the key
    private HashMap<String, Task> tasks;

    public TaskService() {
        tasks = new HashMap<>(); // Initialize the HashMap
    }

    // Method to add a contact
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        tasks.put(task.getTaskId(), task); // Add the task to the HashMap
    }

    // Method to delete a contact by contactID
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        tasks.remove(taskId); // Remove the task from the HashMap
    }

    // Method to update contact fields based on taskID
    public void updateTask(String taskId, String taskName, String taskDescription) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        // Update fields if the new values are not null
        if (taskName != null) {
            task.setTaskName(taskName);
        }
        if (taskDescription != null) {
            task.setTaskDescription(taskDescription);
        }
    }

    // Method to retrieve a contact by contactID
    public Task getTask(String taskId) {
        return tasks.get(taskId); // Return the contact if found, or null if not found
    }
}
