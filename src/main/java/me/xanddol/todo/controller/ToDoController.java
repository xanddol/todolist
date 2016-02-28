package me.xanddol.todo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import me.xanddol.todo.domain.ToDo;
import me.xanddol.todo.domain.ToDoList;
import me.xanddol.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Main application controller
 */
@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @ModelAttribute("todoBean")
    public ToDo createToDoBean() {
        return new ToDo();
    }

    /**
     *  Gets all tasks
     */
    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public ModelAndView displayTodo() {
        ToDoList toDoList = new ToDoList();
        List<ToDo> toDos = toDoService.getAll();
        toDoList.setToDos(toDos);
        return new ModelAndView("todo", "toDoList", toDoList);
    }

    /**
     *  Adds new Task
     */
    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public String addTodo(@Valid ToDo todo, BindingResult result, SessionStatus sessionStatus) {
        //todo use hibernate validator instead
        if (todo.getPriority() == null) {
            todo.setPriority(5); //default priority
        }
        if (todo.getPriority() > 10) {
            todo.setPriority(10);
        }

        if (todo.getDescription() == null || todo.getDescription().isEmpty()) {
            todo.setDescription("Test task # " + new Date()); //default description
        }

        if (todo.getStatus() == null || todo.getStatus().isEmpty()) {
            todo.setStatus("not started"); //default status
        }
        if (todo.getStatus() != null && "in progress".equalsIgnoreCase(todo.getStatus())) {
            todo.setStatus("in progress");
        }

        toDoService.save(todo);
        sessionStatus.setComplete();
        return "redirect:/todo";
    }

    /**
     * Removes Tasks with pointed ID
     */
    @RequestMapping(value = "/todo/delete/{id}", method = RequestMethod.GET)
    public String deleteToDo(@PathVariable int id) {
        toDoService.delete(id);
        return "redirect:/todo";
    }

    /**
     * Allows to edit task with pointed ID
     */
    @RequestMapping(value = "/todo/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id) {
        ToDo toDo = toDoService.getById(id);
        return new ModelAndView("edit", "toDo", toDo);
    }

    /**
     * Edits chosen task
     */
    @RequestMapping(value = "/todo/edit", method = RequestMethod.POST)
    public String update(@RequestParam("id") int id,
                         @RequestParam("description") String description,
                         @RequestParam("status") String status,
                         @RequestParam("priority") int priority) {
        //todo use hibernate validator instead
        if (priority > 10) {
            priority = 10;
        }

        if (description == null || description.isEmpty()) {
            description = "Test task # " + new Date(); //default description
        }

        if (status == null || status.isEmpty()) {
            status = "not started"; //default status
        }
        if (status != null && "in progress".equalsIgnoreCase(status)) {
            status = "in progress";
        }

        ToDo toDo = toDoService.getById(id);
        toDo.setDescription(description);
        toDo.setStatus(status);
        toDo.setPriority(priority);
        toDoService.update(toDo);
        return "redirect:/todo";
    }

    /**
     * Moves task status to Done
     */
    @RequestMapping(value = "/todo/done/{id}", method = RequestMethod.GET)
    public String done(@PathVariable int id) {
        ToDo toDo = toDoService.getById(id);
        toDo.setStatus("done");
        toDoService.update(toDo);
        return "redirect:/todo";
    }

    /**
     * Moves task status to in progress
     */
    @RequestMapping(value = "/todo/inprogress/{id}", method = RequestMethod.GET)
    public String inProgress(@PathVariable int id) {
        ToDo toDo = toDoService.getById(id);
        toDo.setStatus("in progress");
        toDoService.update(toDo);
        return "redirect:/todo";
    }

    @RequestMapping(value = "/todo/updateOrder", method = RequestMethod.POST, headers ={"Accept=application/json"})
    @ResponseBody
    public String updateOrder(@RequestBody String updateEntries) throws JsonProcessingException, IOException, InterruptedException {
        String json = StringUtils.replace(updateEntries, "\\", "");
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.reader();
        JsonNode node = reader.readTree(json);
        JsonNode itemOrder = node.get("updateEntries");
        int size = itemOrder.size();
        for (int i = 0; i < size; i++) {
            int order = itemOrder.get(i).asInt();
            ToDo todo = toDoService.getById(order);
            todo.setPriority(i);
            toDoService.update(todo);
        }
        return "{\"hi\":\"yes\"}";
    }
}
