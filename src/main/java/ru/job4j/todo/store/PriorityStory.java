package ru.job4j.todo.store;

import ru.job4j.todo.model.Priority;

import java.util.Collection;

public interface PriorityStory {

    Collection<Priority> findAllPriorities();
}
