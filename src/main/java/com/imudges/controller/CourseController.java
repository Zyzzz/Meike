package com.imudges.controller;

import com.imudges.model.CourseEntity;
import com.imudges.model.CourseInformationEntity;
import com.imudges.model.CourseListEntity;
import com.imudges.model.PictureEntity;
import com.imudges.repository.CourseRepository;
import com.imudges.repository.LandcViewRepository;
import com.imudges.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */
@Controller
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    PictureRepository pictureRepository;
    @Autowired
    LandcViewRepository landcViewRepository;
    @ResponseBody
    @RequestMapping(value = "/getAllCourse")
    public CourseListEntity getAllCourse(){
        List<CourseEntity> courseEntities = courseRepository.findAll();
        List<PictureEntity> pictureEntities  = pictureRepository.findByPattern(1);
        CourseInformationEntity courseInformationEntity = new CourseInformationEntity();
        List<CourseInformationEntity> courseInformationEntities = new ArrayList<>();
        CourseListEntity courseListEntity = new CourseListEntity();
        for(CourseEntity courseEntity:courseEntities){
            for(PictureEntity pictureEntity :pictureEntities){
                if(courseEntity.getId()==pictureEntity.getOtherid()){
                    courseInformationEntity.setCourseEntity(courseEntity);
                    courseInformationEntity.setPictureEntity(pictureEntity);
                    courseInformationEntities.add(courseInformationEntity);
                }
            }
        }
        courseListEntity.setStatus(0);
        courseListEntity.setCourseInformationEntities(courseInformationEntities);
        return courseListEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/getLessonsByCourseId")
    public List getLessonsByCourseId(int CourseId){
        return landcViewRepository.findBycid(CourseId);
    }

}
