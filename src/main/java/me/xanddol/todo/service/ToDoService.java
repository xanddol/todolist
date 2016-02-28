package me.xanddol.todo.service;

import me.xanddol.todo.domain.ToDo;

import java.util.List;

/**
 * Created by Андрей on 19.02.2016.
 */
public interface ToDoService {

    public void save(ToDo todo);
    public void update(ToDo todo);
    public void delete(ToDo todo);
    public void delete(int id);
    public ToDo getById(int id);
    public List<ToDo> getAll();
}
