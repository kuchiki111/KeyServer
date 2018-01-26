package dao.impl;

import dao.KeyinfoDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.util.List;

public class KeyinfoImpl  extends HibernateDaoSupport implements KeyinfoDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<KeyInfo> showRecords() {
        String hql = "from Keyconfirm";
        List<KeyInfo> list = (List<KeyInfo>) this.getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public KeyInfo findRecordsById(long id) {
        return null;
    }

    @Override
    public KeyInfo findRecordsByKey(String Key) {
        return null;
    }

    @Override
    public boolean update(KeyInfo keyInfo) {
        return false;
    }

    @Override
    public boolean delete(KeyInfo keyInfo) {
        return false;
    }

    @Override
    public boolean inseert(KeyInfo keyInfo) {
        return false;
    }
}
