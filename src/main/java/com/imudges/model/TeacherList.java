package com.imudges.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyy on 2017/2/27.
 */
public class TeacherList {
    private List<TeacherEntity> teacherEntities = new ArrayList<>();

    public List<TeacherEntity> getTeacherEntities() {
        return teacherEntities;
    }

    public void setTeacherEntities(List<TeacherEntity> teacherEntities) {
        this.teacherEntities = teacherEntities;
    }
}
