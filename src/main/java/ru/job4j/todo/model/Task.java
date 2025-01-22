package ru.job4j.todo.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@AllArgsConstructor
public class Task {

    @EqualsAndHashCode.Include
    private int id;

    private String title;

    private String description;

    private LocalDateTime created = LocalDateTime.now();

    private boolean done;

    @ManyToOne
    @JoinColumn(name = "todo_user_id")
    private User user;
}