package dao.impl;

import dao.UserDao;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kuchi
 * Date: 2018/1/11
 * Time: 14:00
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<User> showRecords() {
        String hql = "from User";
        List<User> list = (List<User>) this.getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public int Count() {
        int count = 0;
        String hql = "select count(*) from User ";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
        if (list.size() > 0){
            count = list.get(0).intValue();
        }
        return count;
    }

    @Override
    public User findRecordById(long id) {
        User user = null;
        String hql = "from User where id = ?";
        List<User> list = (List<User>) this.getHibernateTemplate().find(hql,id);
        if (list.size()>0){
            user = list.get(0);
        }
        return user;
    }

    @Override
    public User findRecordByUserNamePassword(String UserName, String Password) {
        User user = null;
        String hql = "from User where username = ? and password = ?";
        List<User> list = (List<User>) this.getHibernateTemplate().find(hql,UserName,Password);
        if (list.size() > 0){
            user = list.get(0);
        }
        return user;
    }

    @Override
    public boolean isUserInfoExist(String UserName) {
        boolean result = false;
        String hql = "from User where username = ? ";
        List<User> list = (List<User>) this.getHibernateTemplate().find(hql,UserName);
        if (list.size() > 0){
            result = true;
        }
        return result;
    }

    @Override
    public boolean isUserInfoExist(String UserName, String Password) {
        boolean result = false;
        String hql = "from User where username = ? and password = ?";
        List<User> list = (List<User>) this.getHibernateTemplate().find(hql,UserName,Password);
        if (list.size() > 0){
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(User userInfo) {
        sessionFactory =  this.getSessionFactory();
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        try{
            s.update(userInfo);
            tx.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insert(User userInfo) {
        sessionFactory = this.getSessionFactory();
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        try{
            s.save(userInfo);
            tx.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(User userInfo) {
        sessionFactory = this.getSessionFactory();
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        try {
            s.delete(userInfo);
            tx.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
