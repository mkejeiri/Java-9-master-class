package sample.model;

public class Task {
    private int taskId;
    private int userId;
    private Long dateCreated;

    public Task() {
    }

    private String description;
    private String task;

    public Task(Long dateCreated, String description, String task) {
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

    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
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
