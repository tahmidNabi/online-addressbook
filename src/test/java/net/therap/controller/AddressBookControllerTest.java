package net.therap.controller;

import net.therap.domain.User;
import net.therap.domain.VCard;
import net.therap.service.VCardService;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.mock.Mock;
import org.unitils.mock.annotation.Dummy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by
 * User: tahmid
 * Date: 6/27/12
 * Time: 12:29 PM
 */

public class AddressBookControllerTest extends UnitilsTestNG {

    @TestedObject
    private AddressBookController addressBookController;

    @InjectIntoByType
    private Mock<VCardService> mockVCardService;


    protected List<VCard> addressBook;

    @Dummy
    protected VCard vCard1, vCard2;

     @Test
    public void testHandleRequest() throws Exception{

        addressBook = Arrays.asList(vCard1, vCard2);

        User user = new User();

        mockVCardService.returns(addressBook).getAddressBook(user);

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();



        mockHttpServletRequest.setMethod("GET");
        mockHttpServletRequest.getSession().setAttribute("User", user);



        ModelAndView modelAndView = addressBookController.handleRequest(mockHttpServletRequest, mockHttpServletResponse);

        Assert.assertEquals("AddressBook", modelAndView.getViewName());

        Assert.assertEquals(addressBook,modelAndView.getModelMap().get("addressBook"));


    }

}
