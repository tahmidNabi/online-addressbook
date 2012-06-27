package net.therap.controller;

import net.therap.command.SearchCmd;
import net.therap.domain.User;
import net.therap.domain.VCard;
import net.therap.service.VCardService;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.crypto.SealedObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchController extends SimpleFormController{

    private VCardService vCardService;

    public void setvCardService(VCardService vCardService) {
        this.vCardService = vCardService;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        SearchCmd searchCmd = new SearchCmd();
        return searchCmd;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        SearchCmd searchCmd = (SearchCmd) command;


        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");

        List<VCard> vCards = vCardService.getVCardsByName(searchCmd,user);

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("vCards",vCards);

        return new ModelAndView("SearchResults", modelMap);

    }
}
