package com.imudges.controller;

import com.imudges.model.StudentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cyy on 2016/12/9.
 */
@Controller
public class UserController {
     private StudentEntity studentEntity;
     @RequestMapping(value = "/login", method = RequestMethod.GET)
     public String ToLogin(){
          return "login";
     }

     @RequestMapping(value = "/register", method = RequestMethod.GET)
     public String ToRegistern(){
          return "register";
     }

     @RequestMapping(value = "/user_register", method = RequestMethod.POST)
     public String Register(String email,String password){

          return "login";
     }
}
