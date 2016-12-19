package com.imudges.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/12/9.
 */
@Entity
@Table(name = "teacher", schema = "newmeike", catalog = "")
public class TeacherEntity extends BaseEntity{
    private int id;
    private String name;
    private int organizatioid;
    private String phone;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherEntity that = (TeacherEntity) o;

        if (id != that.id) return false;
        if (organizatioid != that.organizatioid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + organizatioid;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
