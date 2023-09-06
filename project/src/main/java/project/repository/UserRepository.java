package project.repository;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import project.domain.ChangePass;
import project.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class UserRepository {
    private SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> departmentQuery = session.createQuery("SELECT u FROM User u JOIN FETCH u.customer c JOIN FETCH c.addresses a", User.class);
        return departmentQuery.getResultList();
    }

    public boolean create(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return true;
    }
    public User get(String username) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> userQuery = session.createQuery("from User where username = :username", User.class);
        userQuery.setParameter("username", username);
        List<User> users = userQuery.getResultList();
        if (users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }

    public User get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
    public User get2(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, username);
    }

    public boolean update(User user) {
        System.out.println("--------------");
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        return true;
    }

    public boolean updatePassword(User user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("UPDATE User SET password = :password WHERE username = :username");
        query.setParameter("password", user.getPassword());
        query.setParameter("username", user.getUsername());
        int result = query.executeUpdate();
        return result > 0;
    }
    public boolean delete(User user) {
        System.out.println(user.getCreatedOn());
        System.out.println(user.getPassword());
        System.out.println(user.getFullName());
        System.out.println(user.getEnabled());
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
        return true;
    }
//    public boolean delete(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(user);
//        return true;
//    }

    /*public boolean delete(long userId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            User user = session.get(User.class, userId);
            if (user != null) {
                session.delete(user);
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }*/

}

