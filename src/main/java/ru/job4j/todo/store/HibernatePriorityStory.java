package ru.job4j.todo.store;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.Priority;

import java.util.Collection;

@AllArgsConstructor
@Repository
public class HibernatePriorityStory implements PriorityStory {

    private final CrudRepository crudRepository;

    @Override
    public Collection<Priority> findAllPriorities() {
        return crudRepository.query(
                "FROM Prioryty",
                Priority.class
        );
    }
}
