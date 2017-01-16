package com.imudges.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/1/16.
 */
@Entity
@Table(name = "landvview", schema = "newmeike", catalog = "")
public class LandvviewEntity {
    private Integer time;
    private String name;
    private Integer teacherid;
    private int courseId;
    private Integer videoId;
    private int lid;
    private int vid;
    private String url;

    @Basic
    @Column(name = "time", nullable = true)
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "lid", nullable = false)
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    @Basic
    @Column(name = "vid", nullable = false)
    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 300)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LandvviewEntity that = (LandvviewEntity) o;

        if (courseId != that.courseId) return false;
        if (lid != that.lid) return false;
        if (vid != that.vid) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (teacherid != null ? !teacherid.equals(that.teacherid) : that.teacherid != null) return false;
        if (videoId != null ? !videoId.equals(that.videoId) : that.videoId != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (teacherid != null ? teacherid.hashCode() : 0);
        result = 31 * result + courseId;
        result = 31 * result + (videoId != null ? videoId.hashCode() : 0);
        result = 31 * result + lid;
        result = 31 * result + vid;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
