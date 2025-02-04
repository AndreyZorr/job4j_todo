package ru.job4j.todo.store;

import ru.job4j.todo.model.Category;

import java.util.Collection;
import java.util.Optional;

public interface CategoryStory {

    Collection<Category> findAllCategories();

    Optional<Category> findCategoryById(int id);
}
