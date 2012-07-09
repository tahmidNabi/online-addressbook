package net.therap.controller;

import net.therap.command.RegistrationCmd;
import net.therap.service.UserService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.registry.Registry;

/**
 * Created by
 * User: tahmid
 * Date: 6/26/12
 * Time: 11:39 AM
 */

public class RegistrationController extends SimpleFormController{

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        RegistrationCmd registrationCmd = new RegistrationCmd();

        return registrationCmd;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        RegistrationCmd registrationCmd = (RegistrationCmd) command;

        userService.saveUser(registrationCmd);

        return new ModelAndView(new RedirectView("/online-addressbook/Login.html"));
    }
}
