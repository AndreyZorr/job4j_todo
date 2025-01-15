package ru.job4j.todo.store;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.todo.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class HibernateUserStore implements UserStore {

    private final SessionFactory sf;

    public Optional<User> create(User user) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return Optional.of(user);
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return Optional.empty();
    }

    public Optional<User> findByLogin(String login) {
        Session session = sf.openSession();
        Optional<User> result = Optional.empty();
        try {
            session.getTransaction();
            result = Optional.of(session.createQuery(
                    "From User Where login = :login", ru.job4j.todo.model.User.class)
                    .setParameter(":login", login)
                    .uniqueResult());
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public boolean deleteByLogin(String login) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            result = session.createQuery("Delete Task Where login = :login", User.class)
                    .setParameter("login", login)
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }
}
