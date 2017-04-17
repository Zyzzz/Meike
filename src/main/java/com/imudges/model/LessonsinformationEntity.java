package com.imudges.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/1/16.
 */
@Entity
@Table(name = "lessonsinformation", schema = "newmeike", catalog = "")
public class LessonsinformationEntity {
    private Integer time;
    private int lid;
    private String url;
    private String tname;
    private String phone;
    private int tid;
    private int cid;
    private String cname;
    private String type;
    private int lessonNumber;
    private int organizationid;
    private String lname;
    private Integer teacherid;
    private int courseId;
    private int vid;

    @Basic
    @Column(name = "time", nullable = true)
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Id
    @Column(name = "lid", nullable = false)
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 300)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    @Column(name = "phone", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "tid", nullable = false)
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "cid", nullable = false)
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "cname", nullable = false, length = 50)
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 30)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "lessonNumber", nullable = false)
    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
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
    @Column(name = "lname", nullable = false, length = 255)
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Basic
    @Column(name = "teacherid", nullable = true)
    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    @Basic
    @Column(name = "courseId", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "vid", nullable = false)
    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LessonsinformationEntity that = (LessonsinformationEntity) o;

        if (lid != that.lid) return false;

        if (tid != that.tid) return false;
        if (cid != that.cid) return false;
        if (lessonNumber != that.lessonNumber) return false;
        if (organizationid != that.organizationid) return false;
        if (courseId != that.courseId) return false;
        if (vid != that.vid) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (tname != null ? !tname.equals(that.tname) : that.tname != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (cname != null ? !cname.equals(that.cname) : that.cname != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (lname != null ? !lname.equals(that.lname) : that.lname != null) return false;
        if (teacherid != null ? !teacherid.equals(that.teacherid) : that.teacherid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + lid;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (tname != null ? tname.hashCode() : 0);

        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + tid;
        result = 31 * result + cid;
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + lessonNumber;
        result = 31 * result + organizationid;
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        result = 31 * result + (teacherid != null ? teacherid.hashCode() : 0);
        result = 31 * result + courseId;
        result = 31 * result + vid;
        return result;
    }
}
