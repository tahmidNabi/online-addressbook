package net.therap.controller;

import net.therap.command.LoginCmd;
import net.therap.domain.User;
import net.therap.service.UserService;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.mock.Mock;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/27/12
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginControllerTest extends UnitilsTestNG {

    @TestedObject
    private LoginController loginController;

    @InjectIntoByType
    private Mock<UserService> mockUserService;

    @Test
    public void testAuthenticate() throws Exception{

        LoginCmd loginCmd = new LoginCmd();

        loginController.setCommandClass(loginCmd.getClass());

        String formView = "Login";
        String successView = "Welcome";
        loginController.setFormView( formView );
        loginController.setSuccessView( successView );

        MockHttpServletRequest request = new MockHttpServletRequest( "POST","/Login.html" );
        MockHttpServletResponse response = new MockHttpServletResponse( );

        User user = new User();

        mockUserService.returns(user).Authenticate(loginCmd);

        ModelAndView mv = loginController.handleRequest(request, response);
	    Assert.assertEquals(successView, mv.getViewName());

    }


}
