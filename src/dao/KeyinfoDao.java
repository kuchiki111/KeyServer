package dao;

import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.util.List;

public interface KeyinfoDao {
    List<KeyInfo> showRecords();

    KeyInfo findRecordsById(long id);
    KeyInfo findRecordsByKey(String Key);

    boolean update(KeyInfo keyInfo);
    boolean delete(KeyInfo keyInfo);
    boolean inseert(KeyInfo keyInfo);
}
