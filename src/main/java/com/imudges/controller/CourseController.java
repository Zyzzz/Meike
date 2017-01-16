package com.imudges.controller;

import com.imudges.model.*;
import com.imudges.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @Autowired
    EvaluateViewRepository evaluateViewRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @RequestMapping(value = "/lessons_detail.html", method = RequestMethod.GET)
    public String GoLesson(){
        return "lessons_detail";
    }
    @ResponseBody
    @RequestMapping(value = "/getAllCourse")
    public CourseListEntity getAllCourse(){
        List<CourseEntity> courseEntities = courseRepository.findAll();

        List<PictureEntity> pictureEntities  = pictureRepository.findByPattern(1);

        List<CourseInformationEntity> courseInformationEntities = new ArrayList<>();
        CourseListEntity courseListEntity = new CourseListEntity();
        for(CourseEntity courseEntity:courseEntities){
            for(PictureEntity pictureEntity :pictureEntities){
                if(courseEntity.getId()==pictureEntity.getOtherid()){
                    CourseInformationEntity courseInformationEntity = new CourseInformationEntity();
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
    public LessonsList getLessonsByCourseId(int CourseId){
        LessonsList lessonsList = new LessonsList();
        lessonsList.setLandcviewEntities(landcViewRepository.findBycid(CourseId));
        lessonsList.setCourseEntity(courseRepository.findOne(CourseId));
        lessonsList.setPictureEntity(pictureRepository.findByPatternAndOtherid(1,CourseId));
        lessonsList.setStatus(0);
        return lessonsList;
    }

    @ResponseBody
    @RequestMapping(value = "/getAllComments")
    public CommentList getAllComments(int cid){
        CommentList commentList=new CommentList();
        commentList.setEvaluateviewEntities(evaluateViewRepository.findBycid(cid));
        commentList.setStatus(0);
        return commentList;
    }
}
