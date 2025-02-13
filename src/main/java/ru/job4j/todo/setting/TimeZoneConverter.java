package ru.job4j.todo.setting;

import ru.job4j.todo.model.Task;
import ru.job4j.todo.model.User;

import java.time.ZoneId;
import java.util.Collection;

public class TimeZoneConverter {

    public static Collection<Task> timeZoneConverter(Collection<Task> tasks, User user) {
        for (Task task : tasks) {
            task.getCreated()
                    .atZone(ZoneId.of("UTC"))
                    .withZoneSameLocal(ZoneId.of(user.getTimezone()))
                    .toLocalDateTime();
        }
        return tasks;
    }
}
