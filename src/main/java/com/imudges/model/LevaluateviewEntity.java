package com.imudges.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/1/16.
 */
@Entity
@javax.persistence.Table(name = "levaluateview", schema = "newmeike", catalog = "")
public class LevaluateviewEntity {
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

    private int lid;

    @Basic
    @javax.persistence.Column(name = "lid", nullable = false)
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    private String name;

    @Basic
    @javax.persistence.Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer teacherid;

    @Basic
    @javax.persistence.Column(name = "teacherid", nullable = true)
    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    private int courseId;

    @Basic
    @javax.persistence.Column(name = "courseId", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    private Integer videoId;

    @Basic
    @javax.persistence.Column(name = "videoId", nullable = true)
    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    private Integer time;

    @Basic
    @javax.persistence.Column(name = "time", nullable = true)
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

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

    private Timestamp times;

    @Basic
    @javax.persistence.Column(name = "times", nullable = true)
    public Timestamp getTimes() {
        return times;
    }

    public void setTimes(Timestamp times) {
        this.times = times;
    }

    private Integer lessonid;

    @Basic
    @javax.persistence.Column(name = "lessonid", nullable = true)
    public Integer getLessonid() {
        return lessonid;
    }

    public void setLessonid(Integer lessonid) {
        this.lessonid = lessonid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LevaluateviewEntity that = (LevaluateviewEntity) o;

        if (sid != that.sid) return false;
        if (lid != that.lid) return false;
        if (courseId != that.courseId) return false;
        if (eid != that.eid) return false;
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
        if (teacherid != null ? !teacherid.equals(that.teacherid) : that.teacherid != null) return false;
        if (videoId != null ? !videoId.equals(that.videoId) : that.videoId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (times != null ? !times.equals(that.times) : that.times != null) return false;
        if (lessonid != null ? !lessonid.equals(that.lessonid) : that.lessonid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
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
        result = 31 * result + lid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (teacherid != null ? teacherid.hashCode() : 0);
        result = 31 * result + courseId;
        result = 31 * result + (videoId != null ? videoId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + eid;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (studentid != null ? studentid.hashCode() : 0);
        result = 31 * result + (times != null ? times.hashCode() : 0);
        result = 31 * result + (lessonid != null ? lessonid.hashCode() : 0);
        return result;
    }
}
