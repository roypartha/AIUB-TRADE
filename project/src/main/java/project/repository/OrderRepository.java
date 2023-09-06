package project.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import project.domain.Order;
import project.domain.Product;

import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class OrderRepository {
    private SessionFactory sessionFactory;

    public OrderRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Order> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Order> productTypedQuery = session.createQuery("from Customer_Order", Order.class);
        return productTypedQuery.getResultList();
    }
    public List<Order> list(String username) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Order> productTypedQuery = session.createQuery("from Customer_Order where username = :username",Order.class);
        productTypedQuery.setParameter("username", username);
        return productTypedQuery.getResultList();
    }


    public boolean create(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
        return true;
    }

    public Order get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, id);
    }

    public boolean update(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
        return true;
    }

    public boolean delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        return true;
    }
}
