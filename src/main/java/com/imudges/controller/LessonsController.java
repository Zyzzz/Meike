package com.imudges.controller;

import com.imudges.model.LessonsinformationEntity;
import com.imudges.repository.LessonsinformationRepository;
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

    @ResponseBody
    @RequestMapping(value = "/getLessonsByLid")
    public LessonsinformationEntity getLessonsByLid(int lid){
       return lessonsinformationRepository.findOne(lid);
    }


}
