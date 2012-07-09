package net.therap.dao;

import net.therap.domain.User;

import java.util.List;

/**
 * Created by
 * User: tahmid
 * Date: 6/26/12
 * Time: 11:25 AM
 */

public interface UserDao {

    public User getUserById(int id);

    public List<User> getUsers();

    public void saveUser(User user);
}
