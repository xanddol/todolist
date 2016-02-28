package me.xanddol.todo.dao;

import me.xanddol.todo.domain.ToDo;

import java.util.List;

/**
 * Created by Андрей on 18.02.2016.
 */
public interface ToDoDao {

    public void save(ToDo todo);
    public void update(ToDo todo);
    public void delete(ToDo todo);
    public List<ToDo> getAll();
    public ToDo getById(int id);
}
