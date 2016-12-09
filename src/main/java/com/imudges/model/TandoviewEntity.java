package com.imudges.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/12/9.
 */
@Entity
@Table(name = "tandoview", schema = "newmeike", catalog = "")
public class TandoviewEntity {
    private int tid;
    private String tname;
    private int organizatioid;
    private String phone;
    private int oid;
    private String oname;
    private String information;
    private String address;
    private double rank;
    private String email;
    private String password;

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
    @Column(name = "organizatioid", nullable = false)
    public int getOrganizatioid() {
        return organizatioid;
    }

    public void setOrganizatioid(int organizatioid) {
        this.organizatioid = organizatioid;
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
    @Column(name = "rank", nullable = false, precision = 0)
    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TandoviewEntity that = (TandoviewEntity) o;

        if (tid != that.tid) return false;
        if (organizatioid != that.organizatioid) return false;
        if (oid != that.oid) return false;
        if (Double.compare(that.rank, rank) != 0) return false;
        if (tname != null ? !tname.equals(that.tname) : that.tname != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (oname != null ? !oname.equals(that.oname) : that.oname != null) return false;
        if (information != null ? !information.equals(that.information) : that.information != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = tid;
        result = 31 * result + (tname != null ? tname.hashCode() : 0);
        result = 31 * result + organizatioid;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + oid;
        result = 31 * result + (oname != null ? oname.hashCode() : 0);
        result = 31 * result + (information != null ? information.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        temp = Double.doubleToLongBits(rank);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
