package net.therap.controller;

import net.therap.domain.User;
import net.therap.domain.VCard;
import net.therap.service.VCardService;
import net.therap.utility.SessionKeys;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by
 * User: tahmid
 * Date: 6/26/12
 * Time: 1:59 PM
 */

public class VCardController extends SimpleFormController {

    private VCardService vCardService;

    public void setvCardService(VCardService vCardService) {
        this.vCardService = vCardService;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        int vCardId = ServletRequestUtils.getIntParameter(request, "vCardId");

        VCard vCard = vCardService.getVCardById(vCardId);

        return vCard;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        VCard vCard = (VCard) command;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionKeys.userKey);

        String isDelete = ServletRequestUtils.getStringParameter(request, "delete", null);
        String isUpdate = ServletRequestUtils.getStringParameter(request,"update",null);
        String isExport = ServletRequestUtils.getStringParameter(request,"export",null);

        if (isDelete != null) {
            vCardService.deleteVCard(vCard, user);
        }

        if(isUpdate !=null) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("vCardId",vCard.getvCardId());

            return new ModelAndView(new RedirectView("/online-addressbook/UpdateVCard.html"),modelMap);

        }

        if(isExport !=null) {
            String exportedVCardString = vCardService.exportVCard(vCard);
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("exportedVCardString",exportedVCardString);
            modelMap.addAttribute("name",vCard.getName());
            return new ModelAndView(new RedirectView("/online-addressbook/Download.html"),modelMap);
        }


         return new ModelAndView(new RedirectView("/online-addressbook/Addressbook.html"));
    }
}
