package ru.job4j.todo.store;

import lombok.AllArgsConstructor;
import ru.job4j.todo.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class HibernateUserStore implements UserStore {

    private final CrudRepository crudRepository;

    public Optional<User> create(User user) {
        try {
            crudRepository.run(session -> session.persist(user));
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<User> findByLogin(String login) {
        return crudRepository.optional(
                "From User Where login = :login", User.class,
                Map.of("login", login));
    }

    public boolean deleteByLogin(String login) {
        crudRepository.run("Delete Task Where login = :login",
                Map.of("login", login)
        );
        return true;
    }
}