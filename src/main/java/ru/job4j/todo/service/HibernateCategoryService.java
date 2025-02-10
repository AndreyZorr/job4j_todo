package ru.job4j.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.todo.model.Category;
import ru.job4j.todo.store.CategoryStory;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class HibernateCategoryService implements CategoryService {

    private final CategoryStory categoryStory;

    @Override
    public Collection<Category> findAllCategories() {
        return categoryStory.findAllCategories();
    }

    @Override
    public List<Category> findCategoryById(List<Integer> categoryId) {
        return categoryStory.findCategoryById(categoryId);
    }
}
