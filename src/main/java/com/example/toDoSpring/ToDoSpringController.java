package com.example.toDoSpring;

import com.example.toDoSpring.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.toDoSpring.domain.Task;

import java.util.Map;

@Controller
public class ToDoSpringController {

    @Autowired
    private TaskRepo taskRepo;

    @GetMapping ("main")
    public String Main() {
        return "main";
    }

    @PostMapping ("addtask")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Task task = new Task(text, tag);
        taskRepo.save(task);
        Iterable<Task> tasks = taskRepo.findAll();
        model.put("tasks", tasks);
        return "addTask";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Task> tasks;
        if (filter !=null && !filter.isEmpty()) {
            tasks = taskRepo.findByTag(filter);
        } else {
            tasks = taskRepo.findAll();
        }
        model.put("tasks", tasks);
        return "findTask";
    }

    @GetMapping("alltask")
    public String AllTask(Map<String, Object> model) {
        Iterable<Task> tasks = taskRepo.findAll();
        model.put("tasks", tasks);
        return "allTasks";
    }

    @GetMapping("findtask")
    public String FindTask() {
        return "findTask";
    }

    @GetMapping("addtaskButton")
    public String AddTask() {
        return "addTask";
    }
}