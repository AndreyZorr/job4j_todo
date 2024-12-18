package ru.job4j.todo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.todo.model.Task;
import ru.job4j.todo.service.HibernateTaskService;

@AllArgsConstructor
@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final HibernateTaskService hibernateTaskService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("tasks", hibernateTaskService.findAll());
        return "tasks/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Task task, Model model) {
            boolean isUpdate = hibernateTaskService.update(task);
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
    public String create(@ModelAttribute Task task, Model model) {
            hibernateTaskService.save(task);
            return "redirect:/tasks";
    }

    @GetMapping("/{id}")
    public String delete(Model model, @PathVariable int id) {
        var isDeleted = hibernateTaskService.deleteById(id);
        if (!isDeleted) {
            model.addAttribute("message", "Задание с указанным идентификатором не найдена");
            return "errors/404";
        }
        return "redirect:/one";
    }

    @GetMapping("/done")
    public String getDone(Model model) {
        model.addAttribute("tasks", hibernateTaskService.findAll());
        return "tasks/list";
    }

    @GetMapping("/new")
    public String getNew(Model model) {
        model.addAttribute("tasks", hibernateTaskService.findNew());
        return "redirect:/list";
    }
}