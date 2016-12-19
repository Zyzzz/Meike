package com.imudges.controller;

import com.imudges.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */
@Controller
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @ResponseBody
    @RequestMapping(value = "/getAllCourse")
    public List getAllCourse(){
       return courseRepository.findAll();
    }

}
