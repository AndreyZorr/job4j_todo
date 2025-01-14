package ru.job4j.todo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "todo_users")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@AllArgsConstructor
public class User {

    @EqualsAndHashCode.Include
    private int id;

    private String name;

    private String login;

    private  String password;
}
