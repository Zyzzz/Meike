package com.imudges.model;

/**
 * Created by Administrator on 2016/12/19.
 */
public class CourseInformationEntity {
    private CourseEntity courseEntity;
    private PictureEntity pictureEntity;

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
