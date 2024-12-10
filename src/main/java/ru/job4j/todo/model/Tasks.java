package ru.job4j.todo.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@AllArgsConstructor
public class Tasks {

    @EqualsAndHashCode.Include
    private int id;
    private String description;

    private LocalDateTime created = LocalDateTime.now();

    private boolean done;
}
