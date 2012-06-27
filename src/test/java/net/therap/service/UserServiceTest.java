package net.therap.service;

import net.therap.command.LoginCmd;
import net.therap.dao.UserDao;
import net.therap.domain.User;
import net.therap.service.UserServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.mock.Mock;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/27/12
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceTest extends UnitilsTestNG {

    @TestedObject
    UserServiceImpl userService;

    @InjectIntoByType
    Mock<UserDao> mockUserDao;

    List<User> users;

    LoginCmd loginCmd;

    @BeforeMethod
    public void setUp() {
        User user1 = new User();
        user1.setUserName("Tahmid");
        user1.setPassword("123");

        User user2 = new User();
        user2.setUserName("Pritom");
        user2.setPassword("321");

        users = Arrays.asList(user1,user2);


    }

   @Test
    public void testCorrectAuthentication() throws Exception {

        loginCmd = new LoginCmd();
        loginCmd.setUserName("Tahmid");
        loginCmd.setPassword("123");

        mockUserDao.returns(users).getUsers();

        User user = userService.Authenticate(loginCmd);

        Assert.assertEquals(users.get(0),user);


   }

    @Test
    public void testInCorrectAuthenticationDueToWrongPassword() throws Exception {

        loginCmd = new LoginCmd();
        loginCmd.setUserName("Tahmid");
        loginCmd.setPassword("321");

        mockUserDao.returns(users).getUsers();

        User user = userService.Authenticate(loginCmd);

        Assert.assertEquals(null,user);


   }

    @Test
    public void testInCorrectAuthenticationDueToWrongUser() throws Exception {

        loginCmd = new LoginCmd();
        loginCmd.setUserName("Pritom");
        loginCmd.setPassword("123");

        mockUserDao.returns(users).getUsers();

        User user = userService.Authenticate(loginCmd);

        Assert.assertEquals(null,user);


   }


}
