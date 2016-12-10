package com.imudges.controller;

import com.imudges.model.StudentEntity;
import com.imudges.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cyy on 2016/12/9.
 */
@Controller
public class UserController {
     private StudentEntity studentEntity;
     @Autowired
     private StudentRepository studentRepository;
     @RequestMapping(value = "/login.html", method = RequestMethod.GET)
     public String ToLogin(){
          return "login";
     }

     @RequestMapping(value = "/register.html", method = RequestMethod.GET)
     public String ToRegistern(){
          return "register";
     }

     @RequestMapping(value = "/user_register", method = RequestMethod.POST)
     public String Register(String email,String password){
          studentEntity=new StudentEntity();
          studentEntity.setEmail(email);
          studentEntity.setPassword(password);
          studentRepository.saveAndFlush(studentEntity);
          return "login";
     }

    @ResponseBody
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public StudentEntity userLogin(String email,String password){
        studentEntity = studentRepository.findByEmail(email);
        if(studentEntity==null){
            studentEntity = new StudentEntity();
            studentEntity.setStatus(100);
        }
        else if(!studentEntity.getPassword().equals(password)){
            studentEntity = new StudentEntity();
            studentEntity.setStatus(101);
        }
        else {
            studentEntity.setStatus(0);
        }
       return studentEntity;
    }
}
