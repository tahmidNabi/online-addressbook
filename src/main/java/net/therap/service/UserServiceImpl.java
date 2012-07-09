package net.therap.service;

import net.therap.command.LoginCmd;
import net.therap.command.RegistrationCmd;
import net.therap.dao.UserDao;
import net.therap.domain.User;
import net.therap.domain.VCard;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

/**
 * Created by
 * User: tahmid
 * Date: 6/26/12
 * Time: 11:33 AM
 */

public class UserServiceImpl implements UserService{

    private UserDao userDao;
    Logger logger = Logger.getLogger(this.getClass());


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(RegistrationCmd registrationCmd) {
        User user = new User();
        user.setUserName(registrationCmd.getUserName());
        user.setPassword(registrationCmd.getPassword());
        userDao.saveUser(user);
    }

    public User authenticate(LoginCmd loginCmd) {

        List<User> users = userDao.getUsers();
        for (User user : users) {
            logger.info("LoginCmd email: " + loginCmd.getUserName() + " user email: " + user.getUserName() + " LoginCmd password: " + loginCmd.getPassword() + " user password: " + user.getPassword());
            if (user.getUserName().equals(loginCmd.getUserName()) && user.getPassword().equals(loginCmd.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }


}
