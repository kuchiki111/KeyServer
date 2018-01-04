package service.impl;

import dao.impl.KeyconfirmDaoimpl;
import entity.Keyconfirm;
import service.KeyconfirmService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kuchi
 * Date: 2018/1/2
 * Time: 15:55
 */
public class KeyconfirmServiceImpl implements KeyconfirmService {
    private KeyconfirmDaoimpl keyconfirmDao;

    public void setKeyconfirmDao(KeyconfirmDaoimpl keyconfirmDao){
        this.keyconfirmDao = keyconfirmDao;
    }

    public KeyconfirmDaoimpl getKeyconfirmDao() {
        return keyconfirmDao;
    }

    @Override
    public int Count() {
        int count = keyconfirmDao.Count();
        return count;
    }

    @Override
    public List<Keyconfirm> showRecords() {
        List<Keyconfirm> list = keyconfirmDao.showRecords();
        return list;
    }

    @Override
    public Keyconfirm findRecordById(long id) {
        Keyconfirm keyInfo = keyconfirmDao.findRecordById(id);
        return  keyInfo;
    }

    @Override
    public boolean isKeyExist(String Key) {
        return keyconfirmDao.isKeyInfoExist(Key);
    }

    @Override
    public boolean Login(String Key ,String HddId) {
        return keyconfirmDao.isKeyInfoExist(Key,HddId);
    }

    @Override
    public boolean Register(String Key ,String HddId) {
        Keyconfirm keyInfo = new Keyconfirm();
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        boolean result ;

        keyInfo.setKeyId(Key);
        keyInfo.setHddId(HddId);
        keyInfo.setAddDate(timestamp);

        result = doInsert(keyInfo);
        return result;

    }

    @Override
    public boolean doUpdate(Keyconfirm keyInfo) {
        if (keyconfirmDao.update(keyInfo)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean doInsert(Keyconfirm keyInfo) {
        if (keyconfirmDao.insert(keyInfo)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean doDelete(Keyconfirm keyInfo) {
        if (keyconfirmDao.delete(keyInfo)){
            return true;
        }else {
            return false;
        }
    }
}
