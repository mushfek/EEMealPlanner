package dao;

import domain.Meal;
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
 * Date: 9/17/13
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class MealDaoImpl implements MealDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @PersistenceContext(unitName = "persistDB")
    private EntityManager em;

    @Override
    public Meal getMealById(int id) {
        TypedQuery<Meal> query = em.createQuery("SELECT m FROM Meal m WHERE :id = m.id", Meal.class);
        query.setParameter("id", id);
        try {
            return query.getResultList().get(0);
        } catch (NoResultException e) {
            logger.debug("No Meal Found in {}", new Object[]{id}, e);
        }
        return null;
    }

    @Override
    public Meal getMealByDay(String day) {
        TypedQuery<Meal> query = em.createQuery("SELECT m FROM Meal m WHERE :day = m.day", Meal.class);
        query.setParameter("day", day);
        try {
            return query.getResultList().get(0);
        } catch (NoResultException e) {
            logger.debug("No Meal Found in {}", new Object[]{day}, e);
        }
        return null;
    }

    @Override
    public List<Meal> getMealList() {
        TypedQuery<Meal> query = em.createQuery("SELECT m FROM Meal m", Meal.class);
        return query.getResultList();
    }

    @Override
    public void updateMeal(Meal meal) {
        em.merge(meal);
    }
}
