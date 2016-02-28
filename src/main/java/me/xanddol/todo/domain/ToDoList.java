package me.xanddol.todo.domain;

import java.util.List;

/**
 * Created by Андрей on 17.02.2016.
 */
public class ToDoList {

    private List<ToDo> toDos;

    public List<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }
}
