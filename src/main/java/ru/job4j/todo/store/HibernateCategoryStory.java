package ru.job4j.todo.store;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.Category;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
    public List<Category> findCategoryById(List<Integer> categoryId) {
        return crudRepository.query(
                "FROM Category WHERE id IN :fId",
                Category.class,
                Map.of("fId", categoryId)
        );
    }
}
