package ru.job4j.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.todo.model.Task;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HibernateTaskService {

    private final HibernateTaskService hibernateTaskService;

    public Task save(Task task) {
        return hibernateTaskService.save(task);
    }

    public boolean update(Task task) {
        return hibernateTaskService.update(task);
    }

    public boolean deleteById(int id) {
        var fileOptional = findById(id);
        boolean isPresent = fileOptional.isPresent();
        if (isPresent) {
            hibernateTaskService.deleteById(id);
        }
        return isPresent;
    }

    public Optional<Task> findById(int id) {
        return hibernateTaskService.findById(id);
    }

    public Collection<Task> findAll() {
        return hibernateTaskService.findAll();
    }

    public List<Task> findNew() {
        return hibernateTaskService.findNew();
    }

    public boolean done(int id) {
        return hibernateTaskService.done(id);
    }
}