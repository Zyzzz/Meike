package com.imudges.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/12/9.
 */
@Entity
@Table(name = "eandlview", schema = "newmeike", catalog = "")
public class EandlviewEntity {
    private int eid;
    private String content;
    private Integer studentid;
    private Integer lessonid;
    private Timestamp times;
    private int lid;
    private String name;
    private Integer teacherid;
    private int courseId;
    private Integer videoId;

    @Id
    @Column(name = "eid", nullable = false)
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 200)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "studentid", nullable = true)
    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "lessonid", nullable = true)
    public Integer getLessonid() {
        return lessonid;
    }

    public void setLessonid(Integer lessonid) {
        this.lessonid = lessonid;
    }

    @Basic
    @Column(name = "times", nullable = true)
    public Timestamp getTimes() {
        return times;
    }

    public void setTimes(Timestamp times) {
        this.times = times;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EandlviewEntity that = (EandlviewEntity) o;

        if (eid != that.eid) return false;
        if (lid != that.lid) return false;
        if (courseId != that.courseId) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (lessonid != null ? !lessonid.equals(that.lessonid) : that.lessonid != null) return false;
        if (times != null ? !times.equals(that.times) : that.times != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (teacherid != null ? !teacherid.equals(that.teacherid) : that.teacherid != null) return false;
        if (videoId != null ? !videoId.equals(that.videoId) : that.videoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eid;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (studentid != null ? studentid.hashCode() : 0);
        result = 31 * result + (lessonid != null ? lessonid.hashCode() : 0);
        result = 31 * result + (times != null ? times.hashCode() : 0);
        result = 31 * result + lid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (teacherid != null ? teacherid.hashCode() : 0);
        result = 31 * result + courseId;
        result = 31 * result + (videoId != null ? videoId.hashCode() : 0);
        return result;
    }
}
