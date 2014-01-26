package dao;

import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/16/13
 * Time: 1:09 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @PersistenceContext(unitName = "persistDB")
    private EntityManager em;

    @Override
    public User getUserByInstance(User user) {
        String username = user.getName();
        String password = user.getPassword();

        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.name=:username AND u.password=:password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            return query.getResultList().get(0);
        } catch (NoResultException e) {
            logger.debug("No User Found in {}", new Object[]{user}, e);
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
        query.setParameter("id", id);
        try {
            return query.getResultList().get(0);
        } catch (NoResultException e) {
            logger.debug("No User Found in {}", new Object[]{id}, e);
        }
        return null;
    }

    @Override
    public List<User> getUserList() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
}
