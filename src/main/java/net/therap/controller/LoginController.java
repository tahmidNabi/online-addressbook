package net.therap.controller;

import net.therap.command.LoginCmd;
import net.therap.domain.User;
import net.therap.service.UserService;
import net.therap.utility.SessionKeys;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by
 * user: tahmid
 * Date: 6/7/12
 * Time: 3:19 PM
 */

public class LoginController extends SimpleFormController {

    private UserService userService;


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        LoginCmd loginCmd = new LoginCmd();
        return loginCmd;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

        LoginCmd loginCmd = (LoginCmd) command;
        User user = userService.authenticate(loginCmd);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute(SessionKeys.userKey, user);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute(SessionKeys.messageKey, "Please put correct Username/Password");
            return new ModelAndView(new RedirectView("/online-addressbook/Login.html"));
        }
        return new ModelAndView("Welcome");
    }
}
