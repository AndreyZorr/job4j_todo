package ru.job4j.todo.store;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.Task;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class HibernateTaskStore implements TaskStory {

    private final CrudRepository crudRepository;

    @Override
    public Task save(Task task) {
        crudRepository.run(session -> session.persist(task));
        return task;
    }

    @Override
    public boolean update(Task task) {
        crudRepository.run(session -> session.merge(task));
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        crudRepository.run("Delete Task Where id = fId",
                Map.of("fId", id)
        );
        return true;
    }

    @Override
    public Optional<Task> findById(int id) {
        return crudRepository.optional("From Task as i Where i.id = fId", Task.class,
                Map.of("fId", id)
        );
    }

    @Override
    public List<Task> findAll() {
        return crudRepository.query(
                "From Task t order by t.id ASC", Task.class);
    }

    @Override
    public List<Task> findNew() {
        return crudRepository.query("from Task where done = false", Task.class);
    }

    @Override
    public boolean done(int id) {
        crudRepository.run(
                "From Task Where done = true order by id asc = fId",
                Map.of("fId", id));
        return true;
    }
}
