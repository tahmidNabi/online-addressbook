package net.therap.service;

import net.therap.command.SearchCmd;
import net.therap.dao.VCardDao;
import net.therap.domain.User;
import net.therap.domain.VCard;
import net.therap.service.VCardServiceImpl;
import net.therap.utility.VCardExporter;
import net.therap.utility.VCardImporter;
import net.therap.utility.VersionFourVCardExporter;
import net.therap.utility.VersionFourVCardImporter;
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
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class VCardServiceTest extends UnitilsTestNG{

    @TestedObject
    VCardServiceImpl vCardService;

    @InjectIntoByType
    Mock<VCardDao> mockVCardDao;

    @InjectIntoByType
    Mock<VCardExporter> mockVCardExporter;

    @InjectIntoByType
    Mock<VCardImporter> mockVCardImporter;

    @Test
    public void testGetVCardsByName() throws Exception {

        SearchCmd searchCmd = new SearchCmd();
        searchCmd.setName("ahm");

        User user = new User();

        VCard vCard1 = new VCard();
        vCard1.setFullName("Tahmid-un-Nabi");

        VCard vCard2 = new VCard();
        vCard2.setFullName("Pritom Ahmed");

        List<VCard> vCards = Arrays.asList(vCard1,vCard2);

        mockVCardDao.returns(vCards).getVCardsByName(searchCmd.getName(),user);

        List<VCard> results = vCardService.getVCardsByName(searchCmd,user);

        Assert.assertEquals(2,results.size());




    }

}
