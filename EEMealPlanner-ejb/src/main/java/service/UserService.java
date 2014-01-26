package service;

import dao.UserDao;
import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/16/13
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @EJB
    private UserDao userDao;

    private User currentUser;

    public User loginService(User user) {
        currentUser = userDao.getUserByInstance(user);
        if (currentUser == null) {
            return null;
        } else {
            return currentUser;
        }
    }

    public User getUserByInstance(User user) {
        return userDao.getUserByInstance(user);
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public List<User> getUserList() {
        return userDao.getUserList();
    }
}
