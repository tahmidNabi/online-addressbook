package net.therap.dao;

import net.therap.domain.User;
import net.therap.domain.VCard;
import net.therap.service.VCardService;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import java.util.List;

/**
 * Created by
 * User: tahmid
 * Date: 6/26/12
 * Time: 12:17 PM
 */

public class VCardDaoImpl extends HibernateDaoSupport implements VCardDao{
     protected final Logger logger = Logger.getLogger(this.getClass());

    public void addNewVCard(VCard vCard) {

        Session session = getSession();
        session.saveOrUpdate(vCard);
    }

    public void deleteVCard(VCard vCard) {

       Session session = getSession();
       session.delete(vCard);
       session.flush();
    }

    public VCard getVCardById(int vCardId) {

        VCard vCard = getHibernateTemplate().load(VCard.class,vCardId);
        return vCard;
    }

     public void updateVCard(VCard vCard) {

        Session session = getSession();
        session.merge(vCard);
    }

    public List<VCard> getVCardsByName(String name, User user) {

        Session session = getSession();

        Query query = session.createQuery("from VCard vCard where lower(vCard.fullName) like '%'|| lower(:name) ||'%' and vCard.owningUser.userId = :userId");
        query.setParameter("name", name);
        query.setParameter("userId", user.getUserId());
        List<VCard> vCards = (List<VCard>) query.list();

        logger.info("Size of searchList: " + vCards.size());

        return vCards;
    }
}
