package com.imudges.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/1/16.
 */
@Entity
@Table(name = "landtview", schema = "newmeike", catalog = "")
public class LandtviewEntity {
    private Integer time;
    private int lid;
    private String lname;
    private Integer teacherid;
    private int courseId;
    private Integer videoId;
    private int tid;
    private String tname;
    private int organizatioid;
    private String phone;

    @Basic
    @Column(name = "time", nullable = true)
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Basic
    @Column(name = "lid", nullable = false)
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
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
    @Column(name = "videoId", nullable = true)
    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LandtviewEntity that = (LandtviewEntity) o;

        if (lid != that.lid) return false;
        if (courseId != that.courseId) return false;
        if (tid != that.tid) return false;
        if (organizatioid != that.organizatioid) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (lname != null ? !lname.equals(that.lname) : that.lname != null) return false;
        if (teacherid != null ? !teacherid.equals(that.teacherid) : that.teacherid != null) return false;
        if (videoId != null ? !videoId.equals(that.videoId) : that.videoId != null) return false;
        if (tname != null ? !tname.equals(that.tname) : that.tname != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + lid;
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        result = 31 * result + (teacherid != null ? teacherid.hashCode() : 0);
        result = 31 * result + courseId;
        result = 31 * result + (videoId != null ? videoId.hashCode() : 0);
        result = 31 * result + tid;
        result = 31 * result + (tname != null ? tname.hashCode() : 0);
        result = 31 * result + organizatioid;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
