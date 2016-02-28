package me.xanddol.todo.domain;

import java.io.Serializable;

/**
 * Created by Андрей on 17.02.2016.
 */
public class ToDo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String description;
    private String status;
    private Integer priority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority=" + priority +
                '}';
    }
}
