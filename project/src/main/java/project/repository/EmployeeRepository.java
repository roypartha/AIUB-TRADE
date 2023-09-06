package project.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import project.domain.Employee;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeRepository {
    private SessionFactory sessionFactory;

    public EmployeeRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Employee> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Employee> departmentQuery = session.createQuery("from Employee", Employee.class);
        return departmentQuery.getResultList();
    }

    public boolean create(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
        return true;
    }

    public Employee get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    public boolean update(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
        return true;
    }

    public boolean delete(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(employee);
        return true;
    }
}
