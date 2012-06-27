package net.therap.controller;

import net.therap.command.SearchCmd;
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

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/27/12
 * Time: 3:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchControllerTest extends UnitilsTestNG{

    @TestedObject
    private SearchController searchController;

    @InjectIntoByType
    Mock<VCardService> mockVCardService;

    @Test
    public void testSearch() throws Exception{

        SearchCmd searchCmd = new SearchCmd();

        searchController.setCommandClass(searchCmd.getClass());

        String formView = "Search";
        String successView = "SearchResults";
        searchController.setFormView( formView );
        searchController.setSuccessView( successView );

        MockHttpServletRequest request = new MockHttpServletRequest( "POST","/Search.html" );
        MockHttpServletResponse response = new MockHttpServletResponse( );

        VCard vCard1 = new VCard();
        vCard1.setFullName("Tahmid-un-Nabi");

        VCard vCard2 = new VCard();
        vCard2.setFullName("Pritom Ahmed");

        List<VCard> vCards = Arrays.asList(vCard1, vCard2);

        User user = new User();

        mockVCardService.returns(vCards).getVCardsByName(searchCmd,user);

        ModelAndView mv = searchController.handleRequest(request, response);
	    Assert.assertEquals(successView, mv.getViewName());



    }

}
