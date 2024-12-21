package ru.job4j.todo.store;

import ru.job4j.todo.model.Task;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TaskStory {

    Task save(Task task);

    boolean update(Task task);

    boolean deleteById(int id);

    Optional<Task> findById(int id);

    Collection<Task> findAll();

    List<Task> findNew();

    boolean done(int id);
}
