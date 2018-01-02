package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * User: kuchi
 * Date: 2018/1/2
 * Time: 10:30
 */
@Entity
public class Keyconfirm {
    private int id;
    private String keyId;
    private int hddId;
    private Timestamp addDate;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "key_Id", nullable = false, length = 30)
    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    @Basic
    @Column(name = "hdd_Id", nullable = false)
    public int getHddId() {
        return hddId;
    }

    public void setHddId(int hddId) {
        this.hddId = hddId;
    }

    @Basic
    @Column(name = "add_Date", nullable = true)
    public Timestamp getAddDate() {
        return addDate;
    }

    public void setAddDate(Timestamp addDate) {
        this.addDate = addDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyconfirm that = (Keyconfirm) o;
        return id == that.id &&
                hddId == that.hddId &&
                Objects.equals(keyId, that.keyId) &&
                Objects.equals(addDate, that.addDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, keyId, hddId, addDate);
    }
}
