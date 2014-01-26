package service;

import dao.MealDao;
import domain.Meal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/17/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class MealService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @EJB
    private MealDao mealDao;

    public Meal getMealById(int id) {
        return mealDao.getMealById(id);
    }

    public List<Meal> getMealList() {
        return mealDao.getMealList();
    }

    public void updateMeal(Meal meal) {
        mealDao.updateMeal(meal);
    }

    public Meal getMealByDay(String day) {
        return mealDao.getMealByDay(day);
    }
}
