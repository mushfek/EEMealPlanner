package dao;

import domain.Meal;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/17/13
 * Time: 1:09 PM
 * To change this template use File | Settings | File Templates.
 */

@Local
public interface MealDao {
    public Meal getMealById(int id);

    public Meal getMealByDay(String day);

    public List<Meal> getMealList();

    public void updateMeal(Meal meal);
}
