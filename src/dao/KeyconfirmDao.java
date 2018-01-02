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

    boolean doUpdate(Keyconfirm keyInfo);
    boolean doInsert(Keyconfirm keyInfo);
    boolean doDelete(Keyconfirm keyInfo);

}
