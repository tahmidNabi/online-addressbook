package net.therap.service;

import net.therap.command.LoginCmd;
import net.therap.command.RegistrationCmd;
import net.therap.domain.User;
import net.therap.domain.VCard;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    public User getUserById(int id);

    public void saveUser(RegistrationCmd registrationCmd);

    public User authenticate(LoginCmd loginCmd);

    public List<User> getUsers();




}
