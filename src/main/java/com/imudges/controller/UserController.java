package com.imudges.controller;

import com.imudges.model.BaseEntity;
import com.imudges.model.StudentEntity;
import com.imudges.repository.StudentRepository;
import com.imudges.utils.SHA256Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
     @RequestMapping(value = "/user_register")
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
    @RequestMapping(value = "/userLogin")
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

    @ResponseBody
    @RequestMapping(value = "/email_activate")
    public BaseEntity SendEmail(String cookie,HttpServletRequest request){
        studentEntity=studentRepository.findByCookie(cookie);
        String subject = "";
        StringBuffer url = new StringBuffer();
        StringBuilder builder = new StringBuilder();
        // 判断是否已激活
        if ("1".equals(String.valueOf(studentEntity.getNowstatus()))) {
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setStatus(106);
            return baseEntity;
        }
        String contextPath = request.getContextPath();
        String rUrl = String.valueOf(request.getRequestURL());
        url.append(rUrl.substring(0, rUrl.indexOf(contextPath)));
        url.append(contextPath + "/account");
        // 邮箱激活
        // url.append("/activateEmail.jhtml?email=" + user.getEmail() +
        // "&id=" + uid + "&mode=activate");
        //url.append("/activateEmail.jhtml?id=" + uid + "&mode=activate");
        // 正文
        builder.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" </head><body>");
        builder.append("请点击下方链接激活您的邮箱，完成激活邮箱的操作!");
        builder.append("<br/><br/>");
        builder.append("<a href=\"" + url + "\">");
        builder.append(url);
        builder.append("</a>");
        builder.append("</body></html>");
        subject = "邮箱地址激活 - xxxx";

        //MailSender.mailSimple(user.getEmail(), subject, builder.toString(),
         //       false, null);
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setStatus(0);
        return baseEntity;
    }
}
