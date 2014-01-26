package controller;

import domain.Meal;
import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.MealService;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/17/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@SessionScoped
public class MealController implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private Meal meal;
    private User user;
    private FacesContext facesContext;
    private HttpSession httpSession;
    private Integer userId;

    @EJB
    private MealService mealService;

    @EJB
    private UserService userService;

    @PostConstruct
    public void startUp() {
        logger.debug("before creating meal instance: " + meal);
        if (meal == null) {
            meal = new Meal();
        }
        if (user == null) {
            facesContext = facesContext.getCurrentInstance();
            httpSession = (HttpSession) facesContext.getExternalContext().getSession(true);
            setUser((User) httpSession.getAttribute("user"));
        }
        logger.debug("after creating meal instance: " + meal);
    }

    public List<Meal> getMealList() {
        return mealService.getMealList();
    }

    public String update() {
        mealService.updateMeal(meal);
        return "home.xhtml?faces-redirect=true";
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public HttpSession getHttpSession() {
        return httpSession;
    }

    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public MealService getMealService() {
        return mealService;
    }

    public void setMealService(MealService mealService) {
        this.mealService = mealService;
    }
}
