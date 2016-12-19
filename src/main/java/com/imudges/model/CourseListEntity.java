package com.imudges.model;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */
public class CourseListEntity extends BaseEntity{
    private List<CourseInformationEntity> courseInformationEntities;

    public List<CourseInformationEntity> getCourseInformationEntities() {
        return courseInformationEntities;
    }

    public void setCourseInformationEntities(List<CourseInformationEntity> courseInformationEntities) {
        this.courseInformationEntities = courseInformationEntities;
    }
}
