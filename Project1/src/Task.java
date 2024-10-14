//Robert Umland //
//CS320 C-5     //
//Prof Bermudez //

package grandStrandSystems;

import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private final String taskID; // Unique and not updatable and must be 10 characters or less
    private String taskName; // Cannot be longer than 20 characters, cannot be null
    private String taskDescription;  // Cannot be longer than 50 characters, cannot be null
    public Task(String taskName, String taskDescription) {
        this.taskID = String.format("%010d", idCounter.incrementAndGet()); // Generates a unique ID
        setTaskName(taskName);
        setTaskDescription(taskDescription);
    }

    public String getTaskId() {
        return taskID;
    }

    // Getters for other fields
    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    
    // Setters with validation
    public void setTaskName(String tName) {
        if (tName == null || tName.length() > 20) {
            throw new IllegalArgumentException("Invalid Task Name");
        }
        this.taskName = tName;
    }

    public void setTaskDescription(String tDesc) {
        if (tDesc == null || tDesc.length() > 50) {
            throw new IllegalArgumentException("Invalid Task Description");
        }
        this.taskDescription = tDesc;
    }

    
}

