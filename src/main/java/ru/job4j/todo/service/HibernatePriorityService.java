package ru.job4j.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.todo.model.Priority;
import ru.job4j.todo.store.PriorityStory;

import java.util.Collection;

@Service
@AllArgsConstructor
public class HibernatePriorityService implements PriorityService {

    private final PriorityStory priorityStory;

    @Override
    public Collection<Priority> findAllPriorities() {
        return priorityStory.findAllPriorities();
    }
}
