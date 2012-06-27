package net.therap.controller;

import net.therap.domain.User;
import net.therap.domain.VCard;
import net.therap.service.VCardService;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 1:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddressBookController implements Controller {

    private VCardService vCardService;

    public void setvCardService(VCardService vCardService) {
        this.vCardService = vCardService;
    }

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("User");

        List<VCard> addressBook = vCardService.getAddressBook(user);

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute("addressBook", addressBook);

        return new ModelAndView("AddressBook", modelMap);
    }
}
