package ru.job4j.todo.store;

import ru.job4j.todo.model.Category;

import java.util.Collection;
import java.util.List;

public interface CategoryStory {

    Collection<Category> findAllCategories();

    List<Category> findCategoryById(List<Integer> categoriesId);
}