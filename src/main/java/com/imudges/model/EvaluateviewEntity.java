package com.imudges.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/1/16.
 */
@Entity
@javax.persistence.Table(name = "evaluateview", schema = "newmeike", catalog = "")
public class EvaluateviewEntity {
    private int eid;

    @Id
    @javax.persistence.Column(name = "eid", nullable = false)
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    private String content;

    @Basic
    @javax.persistence.Column(name = "content", nullable = false, length = 200)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Integer studentid;

    @Basic
    @javax.persistence.Column(name = "studentid", nullable = true)
    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    private Integer courseid;

    @Basic
    @javax.persistence.Column(name = "courseid", nullable = true)
    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    private Timestamp times;

    @Basic
    @javax.persistence.Column(name = "times", nullable = true)
    public Timestamp getTimes() {
        return times;
    }

    public void setTimes(Timestamp times) {
        this.times = times;
    }

    private int sid;

    @Basic
    @javax.persistence.Column(name = "sid", nullable = false)
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    private String nickname;

    @Basic
    @javax.persistence.Column(name = "nickname", nullable = true, length = 30)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private Integer age;

    @Basic
    @javax.persistence.Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String phone;

    @Basic
    @javax.persistence.Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String address;

    @Basic
    @javax.persistence.Column(name = "address", nullable = true, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String email;

    @Basic
    @javax.persistence.Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String information;

    @Basic
    @javax.persistence.Column(name = "information", nullable = true, length = 100)
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    private String password;

    @Basic
    @javax.persistence.Column(name = "password", nullable = false, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String cookie;

    @Basic
    @javax.persistence.Column(name = "cookie", nullable = true, length = 255)
    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    private String nowstatus;

    @Basic
    @javax.persistence.Column(name = "nowstatus", nullable = true, length = 255)
    public String getNowstatus() {
        return nowstatus;
    }

    public void setNowstatus(String nowstatus) {
        this.nowstatus = nowstatus;
    }

    private String securityCode;

    @Basic
    @javax.persistence.Column(name = "securityCode", nullable = true, length = 255)
    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    private int cid;

    @Basic
    @javax.persistence.Column(name = "cid", nullable = false)
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    private String name;

    @Basic
    @javax.persistence.Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String type;

    @Basic
    @javax.persistence.Column(name = "type", nullable = false, length = 30)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private int lessonNumber;

    @Basic
    @javax.persistence.Column(name = "lessonNumber", nullable = false)
    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    private int organizationid;

    @Basic
    @javax.persistence.Column(name = "organizationid", nullable = false)
    public int getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(int organizationid) {
        this.organizationid = organizationid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluateviewEntity that = (EvaluateviewEntity) o;

        if (eid != that.eid) return false;
        if (sid != that.sid) return false;
        if (cid != that.cid) return false;
        if (lessonNumber != that.lessonNumber) return false;
        if (organizationid != that.organizationid) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (courseid != null ? !courseid.equals(that.courseid) : that.courseid != null) return false;
        if (times != null ? !times.equals(that.times) : that.times != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (information != null ? !information.equals(that.information) : that.information != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (cookie != null ? !cookie.equals(that.cookie) : that.cookie != null) return false;
        if (nowstatus != null ? !nowstatus.equals(that.nowstatus) : that.nowstatus != null) return false;
        if (securityCode != null ? !securityCode.equals(that.securityCode) : that.securityCode != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eid;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (studentid != null ? studentid.hashCode() : 0);
        result = 31 * result + (courseid != null ? courseid.hashCode() : 0);
        result = 31 * result + (times != null ? times.hashCode() : 0);
        result = 31 * result + sid;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (information != null ? information.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (cookie != null ? cookie.hashCode() : 0);
        result = 31 * result + (nowstatus != null ? nowstatus.hashCode() : 0);
        result = 31 * result + (securityCode != null ? securityCode.hashCode() : 0);
        result = 31 * result + cid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + lessonNumber;
        result = 31 * result + organizationid;
        return result;
    }
}
