package com.imudges.model;

import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
public class LessonsList extends BaseEntity{
    private List<LandcviewEntity> landcviewEntities;
    private CourseEntity courseEntity;
    private PictureEntity pictureEntity;

    public List<LandcviewEntity> getLandcviewEntities() {
        return landcviewEntities;
    }

    public void setLandcviewEntities(List<LandcviewEntity> landcviewEntities) {
        this.landcviewEntities = landcviewEntities;
    }

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }

    public PictureEntity getPictureEntity() {
        return pictureEntity;
    }

    public void setPictureEntity(PictureEntity pictureEntity) {
        this.pictureEntity = pictureEntity;
    }
}
