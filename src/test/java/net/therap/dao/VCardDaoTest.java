package net.therap.dao;

import net.therap.domain.User;
import net.therap.domain.VCard;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.orm.hibernate.HibernateUnitils;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/27/12
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */

@DataSet
@SpringApplicationContext(value = {"classpath:test-applicationContext.xml"})
public class VCardDaoTest extends UnitilsTestNG{

    @SpringBean("vCardDao")
    VCardDao vCardDao;

    @Test
    public void testMappingToDatabase() {
        HibernateUnitils.assertMappingWithDatabaseConsistent();
    }

    @Test
    public void testGetVCardById() {

        VCard vCard = vCardDao.getVCardById(1);

        ReflectionAssert.assertPropertyLenientEquals("name","tahmid", vCard);
    }

    @Test
    @ExpectedDataSet("VCardDaoTest-update-expected.xml")
    public void testUpdate() throws Exception  {

       VCard vCard = vCardDao.getVCardById(1);

        vCard.setFullName("tahmid-un-nabi");

    }

    @Test
    @ExpectedDataSet("VCardDaoTest-delete-expected.xml")
    public void testDelete() throws Exception  {

       VCard vCard = vCardDao.getVCardById(1);

       vCardDao.deleteVCard(vCard);

    }

    @Test
    public void testGetVCardsByName() throws Exception {

        String searchedName = "m";

        User user = new User();
        user.setUserId(1);

        List<VCard> vCards = vCardDao.getVCardsByName(searchedName, user);

        Assert.assertEquals(vCards.size(), 2);



    }




}
