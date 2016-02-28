package me.xanddol.todo.integration;

import me.xanddol.todo.dao.ToDoDao;
import me.xanddol.todo.domain.ToDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/todo-spring.xml")
public class DaoTest {

    //todo add correct logger
    private static final Logger LOGGER = LoggerFactory.getLogger(DaoTest.class);

    @Autowired
    @Qualifier("toDoDao")
    private ToDoDao dao;

    @Test
    public void testEmpty() {
    }

//    @Test
//    public void testSaveToDo() {
//        LOGGER.info("START testSaveToDo()");
//
//        ToDo todo = new ToDo();
//        todo.setDescription("testId=" + UUID.randomUUID());
//        todo.setStatus("in progress");
//        todo.setPriority(1);
//        dao.save(todo);
//
//        LOGGER.info("END testSaveToDo() " + todo);
//    }
//
//    @Test
//    public void testGetToDoList() {
//        LOGGER.info("START testGetToDoList()");
//
//        List<ToDo> todoList = dao.getAll();
//        for (ToDo todo: todoList) {
//            LOGGER.info("Current todo = " + todo);
//        }
//
//        LOGGER.info("END testGetToDoList()");
//    }
//
//    @Test
//    public void testUpdateStatusToDo() {
//        LOGGER.info("START testUpdateToDo()");
//
//        List<ToDo> todoList = dao.getAll();
//        for (ToDo todo: todoList) {
//            todo.setStatus("done");
//            dao.update(todo);
//            LOGGER.info("START update status for " + todo);
//        }
//
//        LOGGER.info("START testUpdateToDo()");
//    }
//
//    @Test
//    public void testUpdatePriorityToDo() {
//        LOGGER.info("START testUpdatePriorityToDo()");
//
//        List<ToDo> todoList = dao.getAll();
//        for (ToDo todo: todoList) {
//            todo.setPriority(10);
//            dao.update(todo);
//            LOGGER.info("START update priority for " + todo);
//        }
//
//        LOGGER.info("START testUpdatePriorityToDo()");
//    }
//
//    @Test
//    public void testDeleteToDo() {
//        LOGGER.info("START testDeleteToDo()");
//
//        List<ToDo> todoList = dao.getAll();
//        for (ToDo todo: todoList) {
//            dao.delete(todo);
//            LOGGER.info("Delete " + todo);
//        }
//
//        LOGGER.info("START testDeleteToDo()");
//    }
}
