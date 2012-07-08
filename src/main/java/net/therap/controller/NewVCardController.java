package net.therap.controller;

import net.therap.domain.User;
import net.therap.domain.VCard;
import net.therap.service.VCardService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 12:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class NewVCardController extends SimpleFormController{

    private VCardService vCardService;

    public void setvCardService(VCardService vCardService) {
        this.vCardService = vCardService;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        VCard vCard = new VCard();

        return vCard;

    }


    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        VCard vCard = (VCard) command;

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("User");

        vCardService.addNewVCard(user, vCard);


        return new ModelAndView(new RedirectView("/online-addressbook/Addressbook.html"));    //To change body of overridden methods use File | Settings | File Templates.
    }
}
