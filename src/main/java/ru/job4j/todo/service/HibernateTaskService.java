package ru.job4j.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.todo.model.Task;
import ru.job4j.todo.store.TaskStory;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HibernateTaskService implements TaskService {

    private final TaskStory taskStory;

    public Task save(Task task) {
        return taskStory.save(task);
    }

    public boolean update(Task task) {
        return taskStory.update(task);
    }

    public boolean deleteById(int id) {
        var fileOptional = findById(id);
        boolean isPresent = fileOptional.isPresent();
        if (isPresent) {
            taskStory.deleteById(id);
        }
        return isPresent;
    }

    public Optional<Task> findById(int id) {
        return taskStory.findById(id);
    }

    public Collection<Task> findAll() {
        return taskStory.findAll();
    }

    public boolean done(int id) {
        return taskStory.done(id);
    }
}
