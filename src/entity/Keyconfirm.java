package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * User: kuchi
 * Date: 2018/1/22
 * Time: 13:05
 */
@Entity
public class Keyconfirm {
    private int id;
    private String keyId;
    private String hddId;
    private String addDate;
    private String lastDate;
    private String addIp;

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
    @Column(name = "hdd_Id", nullable = false, length = 50)
    public String getHddId() {
        return hddId;
    }

    public void setHddId(String hddId) {
        this.hddId = hddId;
    }

    @Basic
    @Column(name = "add_Date", nullable = true, length = 30)
    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    @Basic
    @Column(name = "last_Date", nullable = true, length = 30)
    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    @Basic
    @Column(name = "add_IP", nullable = true, length = 20)
    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyconfirm that = (Keyconfirm) o;
        return id == that.id &&
                Objects.equals(keyId, that.keyId) &&
                Objects.equals(hddId, that.hddId) &&
                Objects.equals(addDate, that.addDate) &&
                Objects.equals(lastDate, that.lastDate) &&
                Objects.equals(addIp, that.addIp);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, keyId, hddId, addDate, lastDate, addIp);
    }
}
