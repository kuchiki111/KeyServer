package service;

import entity.Keyconfirm;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kuchi
 * Date: 2018/1/2
 * Time: 15:54
 */
public interface KeyconfirmService {

    int Count();
    List<Keyconfirm> showRecords();
    Keyconfirm findRecordById(long id);

    boolean updateLastDate(String Key, String HddId);

    boolean isKeyExist(String Key);
    boolean Login(String Key, String HddId);
    boolean Register(String Key, String HddId);

    boolean doUpdate(Keyconfirm keyInfo);
    boolean doInsert(Keyconfirm keyInfo);
    boolean doDelete(Keyconfirm keyInfo);
}
