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

    @GetMapping("/toDoSpring")
    public String toDoSpring(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                             Map<String, Object> model) {
        model.put("name", name);
        return "toDoSpring";
    }

    @GetMapping
    public String Main(Map<String, Object> model) {
        Iterable<Task> tasks = taskRepo.findAll();
        model.put("tasks", tasks);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Task task = new Task(text, tag);
        taskRepo.save(task);
        Iterable<Task> tasks = taskRepo.findAll();
        model.put("tasks", tasks);
        return "main";
    }
}