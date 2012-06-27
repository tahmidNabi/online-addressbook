package net.therap.controller;

import net.therap.domain.VCard;
import net.therap.service.VCardService;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateVCardController extends SimpleFormController{
     Logger logger = Logger.getLogger(this.getClass());

    private VCardService vCardService;

    public void setvCardService(VCardService vCardService) {
        this.vCardService = vCardService;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        int vCardId =  ServletRequestUtils.getIntParameter(request,"vCardId");

        VCard vCard = vCardService.getVCardById(vCardId);

        return vCard;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

        VCard vCard = (VCard) command;
        logger.info("Name: " + vCard.getName() + "Phto: " + vCard.getPhoto());

        vCardService.updateVCard(vCard);

        return new ModelAndView(new RedirectView("/online-addressbook/Addressbook.html"));
    }
}
