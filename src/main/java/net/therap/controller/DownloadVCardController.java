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
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        String ExportedVCard = ServletRequestUtils.getStringParameter(httpServletRequest,"exportedVCardString");
        String fileName = ServletRequestUtils.getStringParameter(httpServletRequest,"name");

        httpServletResponse.setContentType("text/plain; charset=utf-8");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename="+fileName+".vcf");
        httpServletResponse.getOutputStream().write(ExportedVCard.getBytes());
        httpServletResponse.getOutputStream().flush();

        return null;
    }
}
