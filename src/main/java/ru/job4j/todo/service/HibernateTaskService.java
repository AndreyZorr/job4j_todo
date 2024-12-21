package ru.job4j.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.todo.model.Task;
import ru.job4j.todo.store.TaskStory;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HibernateTaskService implements TaskService {

    private final TaskStory taskStory;

    @Override
    public Task save(Task task) {
        return taskStory.save(task);
    }

    @Override
    public boolean update(Task task) {
        return taskStory.update(task);
    }

    @Override
    public boolean deleteById(int id) {
        return taskStory.deleteById(id);
    }

    @Override
    public Optional<Task> findById(int id) {
        return taskStory.findById(id);
    }

    @Override
    public Collection<Task> findAll() {
        return taskStory.findAll();
    }

    @Override
    public List<Task> findNew() {
        return taskStory.findNew();
    }

    @Override
    public boolean done(int id) {
        return taskStory.done(id);
    }
}