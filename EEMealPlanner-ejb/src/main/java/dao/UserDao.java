package dao;

import domain.User;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/16/13
 * Time: 1:06 PM
 * To change this template use File | Settings | File Templates.
 */

@Local
public interface UserDao {
    public User getUserByInstance(User user);

    public User getUserById(int id);

    public List<User> getUserList();
}
