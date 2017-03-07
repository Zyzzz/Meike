package com.imudges.controller;

import com.imudges.model.*;
import com.imudges.repository.EvaluateRepository;
import com.imudges.repository.FavoriteRepository;
import com.imudges.repository.PictureRepository;
import com.imudges.repository.StudentRepository;
import com.imudges.utils.MailSender;
import com.imudges.utils.SHA256Test;
import com.imudges.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;


/**
 * Created by cyy on 2016/12/9.
 */
@Controller
public class UserController {
     private StudentEntity studentEntity;
     private String basePrcture = "http://ohnledfyz.bkt.clouddn.com/author.png";
     @Autowired
     private StudentRepository studentRepository;
    @Autowired
    private EvaluateRepository evaluateRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private PictureRepository pictureRepository;

     @RequestMapping(value = "/login.html", method = RequestMethod.GET)
     public String ToLogin(){
          return "login";
     }

     @RequestMapping(value = "/register.html", method = RequestMethod.GET)
     public String ToRegistern(){
          return "register";
     }

    @RequestMapping(value = "/Per_information.html", method = RequestMethod.GET)
    public String ToPer_information(){
        return "Per_information";
    }

    @RequestMapping(value = "/courses.html", method = RequestMethod.GET)
    public String Course(){
        return "courses";
    }

    @RequestMapping(value = "/course_detail.html", method = RequestMethod.GET)
    public String CourseDetail(){
        return "course_detail";
    }

    @RequestMapping(value = "/Forget_psw.html", method = RequestMethod.GET)
    public String Forget_psw(){
        return "forgetpsw";
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
            studentEntity = studentRepository.findByEmail(email);
            PictureEntity pictureEntity = new PictureEntity();
            pictureEntity.setPattern(0);
            pictureEntity.setOtherid(studentEntity.getId());
            pictureEntity.setUrl(basePrcture);
            pictureRepository.saveAndFlush(pictureEntity);
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
    public BaseEntity ActivateEmail(String cookie,HttpServletRequest request){
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
        url.append(rUrl.substring(0, rUrl.indexOf("/email_activate")));
        //url.append(contextPath + "/account");

         url.append("/activateEmail?"+"cookie=" + studentEntity.getCookie() );

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

        MailSender.mailSimple(studentEntity.getEmail(), subject, builder.toString());
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setStatus(0);
        return baseEntity;
    }


    @RequestMapping(value = "/activateEmail")
    @ResponseBody
    public BaseEntity activateEmail(String cookie) {
        // 激活之前查询
        studentEntity = studentRepository.findByCookie(cookie);

        if ("1".equals(String.valueOf(studentEntity.getNowstatus()))) {
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setStatus(106);
            return baseEntity;

        } else {
            // 未激活
            studentEntity.setNowstatus("1");
            studentRepository.saveAndFlush(studentEntity);
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setStatus(0);
            return baseEntity;
            // 激活之后查询
           /* user = userManager.find(params.getLong("id"));
            request.getSession().setAttribute("sessionUser", user);
            model.addAttribute("mode", params.getString("mode"));
            model.addAttribute("flag", true);*/
        }
        //return "site/modules/account/activateSuccess";
    }

    @RequestMapping(value = "/sendEmail")
    @ResponseBody
    public BaseEntity sendEmail(HttpServletRequest request,String email) {

        System.out.println(email);
        studentEntity=studentRepository.findByEmail(email);
        if(email!=null) {
            StringBuilder builder = new StringBuilder();
            StringBuffer url = new StringBuffer();
            String subject = "";
            // type = forget 密码重置
            String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
            studentEntity.setSecurityCode(verifyCode);
            studentRepository.saveAndFlush(studentEntity);
            request.getSession().setAttribute("resetCertCode", verifyCode);
            url.append("<font color='red'>" + verifyCode + "</font>");
            // 正文
            builder.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body>");
            builder.append("要使用新的密码, 请将已下字符输入验证框中，完成重置密码的操作!");
            builder.append("<br/><br/>");
            builder.append("<div>" + url + "</div>");
            builder.append("</body></html>");
            subject = "密码重置 - xxxx";

            MailSender.mailSimple(email, subject, builder.toString());
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setStatus(0);
            return baseEntity;
        }else {
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setStatus(100);
            return baseEntity;
        }
    }

    @RequestMapping(value = "/ChangePasw")
    @ResponseBody
    public BaseEntity ChangePasw(String verifyCode,String email,String newpassword){
        studentEntity=studentRepository.findByEmail(email);
        BaseEntity baseEntity = new BaseEntity();
        if(studentEntity.getSecurityCode().equals(verifyCode)){
            studentEntity.setSecurityCode(null);
            baseEntity.setStatus(0);
            studentEntity.setPassword(newpassword);
            studentRepository.saveAndFlush(studentEntity);
        }else {
            baseEntity.setStatus(107);
        }
        return baseEntity;
    }

    @RequestMapping(value = "/ModfityStudent")
    @ResponseBody
    public StudentEntity ModfityStudent(String cookie,String nickname,int age, String phone,String address){
        studentEntity=studentRepository.findByCookie(cookie);
        studentEntity.setNickname(nickname);
        studentEntity.setAddress(address);
        studentEntity.setAge(age);
        //studentEntity.setInformation(information);
        studentEntity.setPhone(phone);
        studentRepository.saveAndFlush(studentEntity);
        return studentEntity;
    }

    @RequestMapping(value = "/AddComments")
    @ResponseBody
    public BaseEntity AddComments(String comments,int courseid,String cookie){
        BaseEntity baseEntity=new BaseEntity();
        Timestamp d = new Timestamp(System.currentTimeMillis());
        EvaluateEntity evaluateEntity=new EvaluateEntity();
        evaluateEntity.setContent(comments);
        evaluateEntity.setCourseid(courseid);
        evaluateEntity.setStudentid(studentRepository.findByCookie(cookie).getId());
        evaluateEntity.setTimes(d);
        evaluateRepository.saveAndFlush(evaluateEntity);
        baseEntity.setStatus(0);
        return baseEntity;
    }

    @RequestMapping(value = "/CollectCourse")
    @ResponseBody
    public BaseEntity CollectCourse(int courseID,String cookie){
        FavoriteEntity favoriteEntity;
        BaseEntity baseEntity=new BaseEntity();
        studentEntity = studentRepository.findByCookie(cookie);
        favoriteEntity = favoriteRepository.findByCourseidAndStudentid(courseID,studentEntity.getId());
        if(favoriteEntity==null){
            favoriteEntity = new FavoriteEntity();
            favoriteEntity.setCourseid(courseID);
            favoriteEntity.setStudentid(studentRepository.findByCookie(cookie).getId());
            favoriteRepository.saveAndFlush(favoriteEntity);
            baseEntity.setStatus(0);
            return baseEntity;
        }else {
            baseEntity.setStatus(301);
            return baseEntity;
        }
    }
}
