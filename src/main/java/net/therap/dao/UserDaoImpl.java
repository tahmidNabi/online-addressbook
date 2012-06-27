package net.therap.dao;

import net.therap.domain.User;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

    public User getUserById(int id) {
        User user = getHibernateTemplate().load(User.class, id);

        return user;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<User> getUsers() {

        String queryString = "from User";

        List<User> users = getHibernateTemplate().find(queryString);

        return users;

    }

    public void saveUser(User user) {

        Session session = getSession();
        session.saveOrUpdate(user);
        session.flush();


    }
}
