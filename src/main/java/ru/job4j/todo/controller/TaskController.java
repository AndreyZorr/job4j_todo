package ru.job4j.todo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.todo.model.Task;
import ru.job4j.todo.model.User;
import ru.job4j.todo.service.TaskService;

@AllArgsConstructor
@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "tasks/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Task task, Model model) {
            boolean isUpdate = taskService.update(task);
            if (!isUpdate) {
                model.addAttribute("message", "Задание с указанным идентификатором не найдено");
                return "errors/404";
            }
            return "redirect:/tasks";
    }

    @GetMapping("/create")
    public String getCreationPage(Model model) {
        return "task/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Task task, Model model, @SessionAttribute User user) {
        task.setUser(user);
        taskService.save(task);
            return "redirect:/tasks";
    }

    @GetMapping("/{id}")
    public String delete(Model model, @PathVariable int id) {
        var isDeleted = taskService.deleteById(id);
        if (!isDeleted) {
            model.addAttribute("message", "Задание с указанным идентификатором не найдена");
            return "errors/404";
        }
        return "redirect:/one";
    }

    @GetMapping("/done")
    public String getDone(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "tasks/list";
    }

    @GetMapping("/done/{id}")
    public String done(Model model, @PathVariable int id) {
        if (!taskService.done(id)) {
            model.addAttribute("message", "Задание с указанным идетнификатором не найдено");
            return "errors/404";
        }
        return getAll(model);
    }

    @GetMapping("/new")
    public String getNew(Model model) {
        model.addAttribute("tasks", taskService.findNew());
        return "redirect:/list";
    }

    @GetMapping("/one/{id}")
    public String getOne(Model model, @PathVariable int id) {
        var taskEditing = taskService.findById(id);
        if (taskEditing.isEmpty()) {
            model.addAttribute("message", "Задание с указанным идентификатором не найдено");
            return "errors/404";
        }
        return "task/one";
    }

    @GetMapping("/edit/{id}")
    public String getByIdToEdit(Model model, @PathVariable int id) {
        var tastOptional = taskService.findById(id);
        if (tastOptional.isEmpty()) {
            model.addAttribute("message", "Задача с указанным идентификатором не найдена");
            return "errors/404";
        }
        model.addAttribute("task", tastOptional.get());
        return "tasks/edit";
    }
}
