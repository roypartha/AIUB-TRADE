package project.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import project.domain.User;

import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class AdminRepository {
    private SessionFactory sessionFactory;

    public AdminRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
