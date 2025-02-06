package ru.job4j.todo.store;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.Category;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class HibernateCategoryStory implements CategoryStory {

    private final CrudRepository crudRepository;

    @Override
    public Collection<Category> findAllCategories() {
        return crudRepository.query(
                "FROM Category", Category.class
        );
    }

    @Override
    public Optional<Category> findCategoryById(int id) {
        return crudRepository.optional(
                "FROM Category WHERE id = :fId",
                Category.class,
                Map.of("fId", id)
        );
    }
}