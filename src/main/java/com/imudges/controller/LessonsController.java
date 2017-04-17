package com.imudges.controller;

import com.imudges.model.Lesson;
import com.imudges.model.LessonsinformationEntity;
import com.imudges.model.PictureEntity;
import com.imudges.repository.LessonsinformationRepository;
import com.imudges.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/12/20.
 */
@Controller
public class LessonsController {
    @Autowired
    LessonsinformationRepository lessonsinformationRepository;
    @Autowired
    PictureRepository pictureRepository;
    @ResponseBody
    @RequestMapping(value = "/getLessonsByLid")
    public Lesson getLessonsByLid(int lid){
        Lesson lesson = new Lesson();
        LessonsinformationEntity lessonsinformationEntity;
        lessonsinformationEntity = lessonsinformationRepository.findOne(lid);
        lesson.setLessonsinformationEntity(lessonsinformationEntity);
        PictureEntity pictureEntity = pictureRepository.findByPatternAndOtherid(3,lessonsinformationEntity.getTid());
        lesson.setPictureEntity(pictureEntity);
        return lesson;
    }


}
