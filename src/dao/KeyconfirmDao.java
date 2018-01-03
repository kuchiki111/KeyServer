package dao;

import entity.Keyconfirm;

import java.security.Key;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kuchi
 * Date: 2018/1/2
 * Time: 13:32
 */
public interface KeyconfirmDao {

    List<Keyconfirm> showRecords();
    int Count();

    Keyconfirm findRecordById(long id);
    Keyconfirm findRecordByKey(String Key);
    Keyconfirm findRecordByKeyAndHdd(String Key ,String HddId);

    boolean isKeyInfoExist(String Key);
    boolean isKeyInfoExist(String Key ,String HddId);

    boolean update(Keyconfirm keyInfo);
    boolean insert(Keyconfirm keyInfo);
    boolean delete(Keyconfirm keyInfo);

}
