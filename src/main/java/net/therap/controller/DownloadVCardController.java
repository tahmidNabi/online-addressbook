package net.therap.controller;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class DownloadVCardController extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String ExportedVCard = ServletRequestUtils.getStringParameter(request,"exportedVCardString");
        String fileName = ServletRequestUtils.getStringParameter(request,"name");

        response.setContentType("text/plain; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".vcf");
        response.getOutputStream().write(ExportedVCard.getBytes());
        response.getOutputStream().flush();

        return null;
    }
}
