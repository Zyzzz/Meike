package com.imudges.model;

/**
 * Created by Administrator on 2017/4/17.
 */
public class Lesson {
    private LessonsinformationEntity lessonsinformationEntity;
    private PictureEntity pictureEntity;

    public LessonsinformationEntity getLessonsinformationEntity() {
        return lessonsinformationEntity;
    }

    public void setLessonsinformationEntity(LessonsinformationEntity lessonsinformationEntity) {
        this.lessonsinformationEntity = lessonsinformationEntity;
    }

    public PictureEntity getPictureEntity() {
        return pictureEntity;
    }

    public void setPictureEntity(PictureEntity pictureEntity) {
        this.pictureEntity = pictureEntity;
    }
}
