package com.ngonyoku.model;

public class Task {
    private long dateCreated;
    private String description;
    private String task;

    public Task() {
    }

    public Task(long dateCreated, String description, String task) {
        this.dateCreated = dateCreated;
        this.description = description;
        this.task = task;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public String getTask() {
        return task;
    }
}
