package ru.job4j.todo.service;

import ru.job4j.todo.model.Category;

import java.util.Collection;
import java.util.Optional;

public interface CategoryService {

    Collection<Category> findAllCategories();

    Optional<Category> findCategoryById(Optional<Integer> categoryId);
}