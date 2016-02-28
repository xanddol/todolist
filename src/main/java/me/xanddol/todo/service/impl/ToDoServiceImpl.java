package me.xanddol.todo.service.impl;

import me.xanddol.todo.dao.ToDoDao;
import me.xanddol.todo.domain.ToDo;
import me.xanddol.todo.service.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Андрей on 19.02.2016.
 */
@Service("toDoService")
public class ToDoServiceImpl implements ToDoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ToDoServiceImpl.class);

    @Autowired
    private ToDoDao toDoDao;

    public void save(ToDo toDo) {
        LOGGER.info("ToDoServiceImpl save " + toDo);
        toDoDao.save(toDo);
    }

    public void update(ToDo toDo) {
        LOGGER.info("ToDoServiceImpl update " + toDo);
        toDoDao.update(toDo);
    }

    public void delete(ToDo toDo) {
        LOGGER.info("ToDoServiceImpl delete " + toDo);
        toDoDao.delete(toDo);
    }

    public ToDo getById(int id) {
        LOGGER.info("ToDoServiceImpl getById " + id);
        return toDoDao.getById(id);
    }

    public List<ToDo> getAll() {
        LOGGER.info("ToDoServiceImpl getAll");
        return toDoDao.getAll();
    }

    public void delete(int id) {
        LOGGER.info("ToDoServiceImpl delete " + id);
        ToDo toDo = toDoDao.getById(id);
        if (toDo != null) {
            toDoDao.delete(toDo);
        }
    }
}
