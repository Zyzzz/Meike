package com.imudges.controller;

import com.imudges.model.StudentEntity;
import com.imudges.repository.StudentRepository;
import com.imudges.utils.SHA256Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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

    @ResponseBody
     @RequestMapping(value = "/user_register", method = RequestMethod.POST)
     public StudentEntity Register(String email,String password){
        studentEntity = studentRepository.findByEmail(email);
        if(studentEntity==null) {
            studentEntity = new StudentEntity();
            studentEntity.setEmail(email);
            studentEntity.setPassword(password);
            studentRepository.saveAndFlush(studentEntity);
            studentEntity.setStatus(0);
        }
        else {
            studentEntity = new StudentEntity();
            studentEntity.setStatus(102);
        }
        return studentEntity;
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
            String cookie = SHA256Test.SHA256Encrypt(email+new Date().toString());
            studentEntity.setCookie(cookie);

            studentRepository.saveAndFlush(studentEntity);
            studentEntity.setStatus(0);
        }
       return studentEntity;
    }
}
