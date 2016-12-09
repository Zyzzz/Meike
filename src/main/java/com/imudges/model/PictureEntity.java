package com.imudges.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/12/9.
 */
@Entity
@Table(name = "picture", schema = "newmeike", catalog = "")
public class PictureEntity {
    private int id;
    private String url;
    private int pattern;
    private int otherid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url", nullable = false, length = 100)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "pattern", nullable = false)
    public int getPattern() {
        return pattern;
    }

    public void setPattern(int pattern) {
        this.pattern = pattern;
    }

    @Basic
    @Column(name = "otherid", nullable = false)
    public int getOtherid() {
        return otherid;
    }

    public void setOtherid(int otherid) {
        this.otherid = otherid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PictureEntity that = (PictureEntity) o;

        if (id != that.id) return false;
        if (pattern != that.pattern) return false;
        if (otherid != that.otherid) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + pattern;
        result = 31 * result + otherid;
        return result;
    }
}
