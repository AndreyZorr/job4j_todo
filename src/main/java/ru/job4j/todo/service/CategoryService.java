package ru.job4j.todo.service;

import ru.job4j.todo.model.Category;

import java.util.Collection;
import java.util.List;

public interface CategoryService {

    Collection<Category> findAllCategories();

    List<Category> findCategoryById(List<Integer> categoriesId);
}
