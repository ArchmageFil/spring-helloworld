package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getByCar(Car car) {
        Query<User> query = sessionFactory.getCurrentSession().createQuery(
                "SELECT u from User u where u.car.model = :carModel and " +
                        "u.car.series = :carSeries", User.class);
        query.setParameter("carModel", car.getModel())
                .setParameter("carSeries", car.getSeries());
        return query.setMaxResults(1).getSingleResult();
    }

}
