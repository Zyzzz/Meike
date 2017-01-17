package com.imudges.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/1/16.
 */
@Entity
@Table(name = "evaluate", schema = "newmeike", catalog = "")
public class EvaluateEntity {
    private int id;
    private String content;
    private Integer studentid;
    private Integer courseid;
    private Timestamp times;
    private Integer lessonid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 200)
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
    @Column(name = "courseid", nullable = true)
    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
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
    @Column(name = "lessonid", nullable = true)
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

        EvaluateEntity that = (EvaluateEntity) o;

        if (id != that.id) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (courseid != null ? !courseid.equals(that.courseid) : that.courseid != null) return false;
        if (times != null ? !times.equals(that.times) : that.times != null) return false;
        if (lessonid != null ? !lessonid.equals(that.lessonid) : that.lessonid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (studentid != null ? studentid.hashCode() : 0);
        result = 31 * result + (courseid != null ? courseid.hashCode() : 0);
        result = 31 * result + (times != null ? times.hashCode() : 0);
        result = 31 * result + (lessonid != null ? lessonid.hashCode() : 0);
        return result;
    }
}
