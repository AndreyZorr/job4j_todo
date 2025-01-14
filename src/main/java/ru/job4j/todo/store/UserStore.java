package ru.job4j.todo.store;

import ru.job4j.todo.model.User;

import java.util.Optional;

public interface UserStore {

    Optional<User> create(User user);

    Optional<User> findByLogin(String login);

    boolean deleteByLogin(String login);
}
