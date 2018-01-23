package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "keyinfo", schema = "sagacloud", catalog = "")
public class KeyinfoEntity {
    private int id;
    private int keyId;
    private String status;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "key_Id")
    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyinfoEntity that = (KeyinfoEntity) o;
        return id == that.id &&
                keyId == that.keyId &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, keyId, status);
    }
}
