package net.therap.dao;

import net.therap.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {

    public User getUserById(int id);

    public List<User> getUsers();

    public void saveUser(User user);
}
