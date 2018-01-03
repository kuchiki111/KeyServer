package dao.impl;

import dao.KeyconfirmDao;
import entity.Keyconfirm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kuchi
 * Date: 2018/1/2
 * Time: 13:54
 */
public class KeyconfirmDaoimpl extends HibernateDaoSupport implements KeyconfirmDao{
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Keyconfirm> showRecords() {
        String hql = "from Keyconfirm";
        List<Keyconfirm> list = (List<Keyconfirm>) this.getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public int Count() {
        String hql = "select count(*) from Keyconfirm ";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
        if (list.size() > 0){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public Keyconfirm findRecordById(long id) {
        return null;
    }

    @Override
    public Keyconfirm findRecordByKey(String Key) {
        String hql = "from Keyconfirm where keyId = ? ";
        List<Keyconfirm> list = (List<Keyconfirm>) this.getHibernateTemplate().find(hql,Key);
        if(list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public Keyconfirm findRecordByKeyAndHdd(String Key, String HddId) {
        String hql = "from Keyconfirm where keyId = ? and hddId = ? ";
        List<Keyconfirm> list = (List<Keyconfirm>) this.getHibernateTemplate().find(hql,Key,HddId);
        if(list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public boolean isKeyInfoExist(String Key) {
        String hql = "from Keyconfirm where keyId = ? ";
        List<Keyconfirm> list = (List<Keyconfirm>) this.getHibernateTemplate().find(hql,Key);
        if(list.size() == 0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean isKeyInfoExist(String Key, String HddId) {
        String hql = "from Keyconfirm where keyId = ? and hddId = ? ";
        List<Keyconfirm> list = (List<Keyconfirm>) this.getHibernateTemplate().find(hql,Key,HddId);
        if(list.size() == 0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean update(Keyconfirm keyInfo) {
        sessionFactory =  this.getSessionFactory();
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        try{
            s.update(keyInfo);
            tx.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insert(Keyconfirm keyInfo) {
        sessionFactory = this.getSessionFactory();
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        try{
            s.save(keyInfo);
            tx.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Keyconfirm keyInfo) {
        sessionFactory = this.getSessionFactory();
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        try {
            s.delete(keyInfo);
            tx.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
