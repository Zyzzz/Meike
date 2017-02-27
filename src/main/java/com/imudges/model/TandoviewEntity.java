package com.imudges.model;
import javax.persistence.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by cyy on 2017/2/27.
 */
@Entity
@Table(name = "tandoview", schema = "newmeike", catalog = "")
public class TandoviewEntity {
    private int tid;
    private String tname;
    private int organizationid;
    private String phone;
    private int oid;
    private String oname;
    private String information;
    private String address;
    private String securityCode;
    private double rank;

    @Id
    @Column(name = "tid", nullable = false)
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "tname", nullable = false, length = 20)
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Basic
    @Column(name = "organizationid", nullable = false)
    public int getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(int organizationid) {
        this.organizationid = organizationid;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "oid", nullable = false)
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "oname", nullable = false, length = 30)
    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    @Basic
    @Column(name = "information", nullable = false, length = 120)
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 30)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "securityCode", nullable = true, length = 255)
    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Basic
    @Column(name = "rank", nullable = false, precision = 0)
    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TandoviewEntity that = (TandoviewEntity) o;

        if (tid != that.tid) return false;
        if (organizationid != that.organizationid) return false;
        if (oid != that.oid) return false;
        if (Double.compare(that.rank, rank) != 0) return false;
        if (tname != null ? !tname.equals(that.tname) : that.tname != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (oname != null ? !oname.equals(that.oname) : that.oname != null) return false;
        if (information != null ? !information.equals(that.information) : that.information != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (securityCode != null ? !securityCode.equals(that.securityCode) : that.securityCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = tid;
        result = 31 * result + (tname != null ? tname.hashCode() : 0);
        result = 31 * result + organizationid;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + oid;
        result = 31 * result + (oname != null ? oname.hashCode() : 0);
        result = 31 * result + (information != null ? information.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (securityCode != null ? securityCode.hashCode() : 0);
        temp = Double.doubleToLongBits(rank);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
