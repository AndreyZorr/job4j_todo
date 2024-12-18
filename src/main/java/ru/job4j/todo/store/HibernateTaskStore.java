package ru.job4j.todo.store;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class HibernateTaskStore {

    private final SessionFactory sf;

    public Task save(Task task) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return task;
    }


    public boolean updateTitle(Task task) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.update(task.getTitle());
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public boolean updateDesc(Task task) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.update(task.getDescription());
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public boolean deleteById(int id) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            result = session.createQuery("Delete Task Where id = fId")
                    .setParameter("fId", id)
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public Optional<Task> findById(int id) {
        Session session = sf.openSession();
        Optional<Task> result = Optional.empty();
        try {
            session.getTransaction();
            result = Optional.of(session.createQuery(
                    "From Task as i Where i.id = fId", Task.class)
                    .setParameter(":fId", id)
                    .uniqueResult());
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public List<Task> findAll() {
        Session session = sf.openSession();
        List<Task> result = new ArrayList<>();
        try {
            session.beginTransaction();
            result = session.createQuery(
                    "From Task", Task.class)
                    .list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public List<Task> findNew() {
        Session session = sf.openSession();
        List<Task> result = new ArrayList<>();
        try {
            session.beginTransaction();
            result = session.createQuery("from Task where done = false", Task.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public boolean done(int id) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.createQuery(
                    "From Task Where done = true order by id asc = fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }
}
