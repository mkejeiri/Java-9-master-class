package sample.model;

import java.sql.Time;
import java.sql.Timestamp;

public class Task {
    private int taskId;
    private int userId;
    private Timestamp dateCreated;

    public Task() {
    }

    private String description;
    private String task;

    public Task(Timestamp dateCreated, String description, String task) {
        this.dateCreated = dateCreated;
        this.description = description;
        this.task = task;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
