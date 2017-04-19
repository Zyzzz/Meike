package com.imudges.controller;

import com.imudges.model.*;
import com.imudges.repository.*;
import com.imudges.utils.MailSender;
import com.imudges.utils.SHA256Test;
import com.imudges.utils.Upload;
import com.imudges.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.imudges.utils.FileUpload.uploadFile;

/**
 * Created by cyy on 2016/12/10.
 */
@Controller
public class OrganizationController {
    private TeacherEntity teacherEntity;
    private  OrganizationEntity organizationEntity;
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private LessonsRepository lessonsRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private PictureRepository pictureRepository;

    @RequestMapping(value = "/O_sign-in", method = RequestMethod.GET)
    public String OrganizationLogin(){
        return "O_sign-in";
    }
    @RequestMapping(value = "/O_sign-up", method = RequestMethod.GET)
    public String OrganizationLogup(){
        return "O_sign-up";
    }
    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public String Teacher(){
        return "teacher";
    }
    @RequestMapping(value = "/O_allcourse", method = RequestMethod.GET)
    public String O_allcourse(){
        return "O_allcourse";
    }
    @RequestMapping(value = "/O_addcourse", method = RequestMethod.GET)
    public String O_addcourse(){
        return "O_addcourse";
    }
    @RequestMapping(value = "/O_alltype", method = RequestMethod.GET)
    public String O_alltype(){
        return "O_alltype";
    }
    @RequestMapping(value = "/O_alllessons", method = RequestMethod.GET)
    public String O_alllessonse(){
        return "O_alllessons";
    }

    @RequestMapping(value = "/O_addlessons", method = RequestMethod.GET)
    public String O_addlessons(){
        return "O_addlessons";
    }
    @ResponseBody
    @RequestMapping(value = "/Ologin")
    public OrganizationEntity Ologin(String email,String password){
        organizationEntity = organizationRepository.findByEmail(email);
        if(organizationEntity==null){
            organizationEntity = new OrganizationEntity();
            organizationEntity.setStatus(100);
        }
        else if(!organizationEntity.getPassword().equals(password)){
            organizationEntity = new OrganizationEntity();
            organizationEntity.setStatus(101);
        }
        else {
            String cookie = SHA256Test.SHA256Encrypt(email+new Date().toString());
            organizationEntity.setCookie(cookie);
            organizationRepository.saveAndFlush(organizationEntity);
            organizationEntity.setStatus(0);
        }
        return organizationEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/Ologup")
    public OrganizationEntity Ologup(String email,String password ){
        OrganizationEntity organizationEntity = organizationRepository.findByEmail(email);
        if(organizationEntity==null) {
            organizationEntity = new OrganizationEntity();
            organizationEntity.setEmail(email);
            organizationEntity.setPassword(password);
            organizationRepository.saveAndFlush(organizationEntity);
            organizationEntity.setStatus(0);
        }
        else {
            organizationEntity = new OrganizationEntity();
            organizationEntity.setStatus(102);
        }
        return organizationEntity;
    }


    @ResponseBody
    @RequestMapping(value = "/Setting_message")
    public OrganizationEntity Setting_message(String cookie,String name,String information,String address){
        organizationEntity=organizationRepository.findByCookie(cookie);
        if(name==null) name=organizationEntity.getName();
        organizationEntity.setName(name);
        if(information==null) name=organizationEntity.getInformation();
        organizationEntity.setInformation(information);
        if(address==null) name=organizationEntity.getAddress();
        organizationEntity.setAddress(address);
        organizationRepository.saveAndFlush(organizationEntity);
        return organizationEntity;
    }



    @RequestMapping(value = "/O_sendEmail")
    @ResponseBody
    public BaseEntity sendEmail(HttpServletRequest request, String email) {

        organizationEntity=organizationRepository.findByEmail(email);
        if(email!=null) {
            StringBuilder builder = new StringBuilder();
            StringBuffer url = new StringBuffer();
            String subject = "";
            // type = forget 密码重置
            String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
            organizationEntity.setSecurityCode(verifyCode);
            organizationRepository.saveAndFlush(organizationEntity);
            request.getSession().setAttribute("resetCertCode", verifyCode);
            url.append("<font color='red'>" + verifyCode + "</font>");
            // 正文
            builder.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body>");
            builder.append("要使用新的密码, 请将已下字符输入验证框中，完成重置密码的操作!");
            builder.append("<br/><br/>");
            builder.append("<div>" + url + "</div>");
            builder.append("</body></html>");
            subject = "密码重置 - xxxx";
            MailSender.mailSimple(organizationEntity.getEmail(), subject, builder.toString());
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setStatus(0);
            return baseEntity;
        }else {
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setStatus(100);
            return baseEntity;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/Change_Password")
    public BaseEntity Change_Password(String verifyCode,String email,String newpassword){
        BaseEntity baseEntity=new BaseEntity();
        organizationEntity=organizationRepository.findByEmail(email);
        if(organizationEntity.getSecurityCode().equals(verifyCode)){
            baseEntity.setStatus(0);
            organizationEntity.setPassword(newpassword);
            organizationRepository.saveAndFlush(organizationEntity);
        }else {
            baseEntity.setStatus(107);
        }
        return baseEntity;
    }
    @ResponseBody
    @RequestMapping(value = "/show_teacher")
    public List<TeacherEntity> ShowTeacher(){
        List<TeacherEntity> teacherEntityList=teacherRepository.findAll();
        return teacherEntityList;
    }


    @ResponseBody
    @RequestMapping(value = "/getAllType")
    public List<String> getAllType(String cookie){
        organizationEntity=organizationRepository.findByCookie(cookie);
        return courseRepository.findTypeByOrgaizationid(organizationEntity.getId());
    }
    @ResponseBody
    @RequestMapping(value = "/getOCourseByType")
    public List<CourseEntity> getCourseByType(String cookie,String Type){
        organizationEntity=organizationRepository.findByCookie(cookie);
        return courseRepository.findByorganizationidAndType(organizationEntity.getId(),Type);
    }


    @ResponseBody
    @RequestMapping(value = "/Add_teacher")
    public TeacherEntity AddTeacher(String cookie,String name,String phone) {

        teacherEntity=new TeacherEntity();
        organizationEntity=organizationRepository.findByCookie(cookie);
        teacherEntity.setName(name);
        teacherEntity.setOrganizationid(organizationEntity.getId());
        teacherEntity.setPhone(phone);
        teacherEntity.setStatus(0);
        teacherRepository.saveAndFlush(teacherEntity);
        teacherEntity=teacherRepository.findByNameAndPhoneAndOrganizationid(name,phone,organizationEntity.getId());
        return teacherEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/uploadPicture")
    public PictureEntity uploadPicture(int tid,MultipartFile picture,HttpServletRequest request) throws IOException {
        String filePath3 = uploadFile(picture, request);
        Upload upload  = new Upload();
        File file= new File(filePath3);
        String url = upload.upload(file);
        PictureEntity pictureEntity = new PictureEntity();
        pictureEntity.setUrl(url);
        pictureEntity.setPattern(3);
        pictureEntity.setOtherid(tid);
        pictureRepository.saveAndFlush(pictureEntity);
        return  pictureEntity;
    }


    @ResponseBody
    @RequestMapping(value = "/Delete_teacher")
    public BaseEntity DeleteTeacher(int id){
        BaseEntity baseEntity=new BaseEntity();
        teacherRepository.delete(id);
        baseEntity.setStatus(0);
        return baseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/addCourse")
    public BaseEntity addCourse(String cookie,String cname,String type,String description,MultipartFile picture,HttpServletRequest request) throws IOException{
        BaseEntity baseEntity = new BaseEntity();
        CourseEntity courseEntity = new CourseEntity();
        OrganizationEntity organizationEntity = organizationRepository.findByCookie(cookie);
        //courseEntity.setLessonNumber(lessonNumber);
        courseEntity.setType(type);
        courseEntity.setOrganizationid(organizationEntity.getId());
        courseEntity.setDescription(description);
        courseEntity.setName(cname);
        courseRepository.saveAndFlush(courseEntity);
        courseEntity = courseRepository.findOrderByNameAndType(cname,type);
        String filePath3 = uploadFile(picture, request);
        Upload upload  = new Upload();
        File file= new File(filePath3);
        String url = upload.upload(file);
        PictureEntity pictureEntity = new PictureEntity();
        pictureEntity.setUrl(url);
        pictureEntity.setPattern(2);
        pictureEntity.setOtherid(courseEntity.getId());
        pictureRepository.saveAndFlush(pictureEntity);
        baseEntity.setStatus(0);
        return baseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteCourse")
    public BaseEntity deleteCourse(String cookie,int cid){
        BaseEntity baseEntity = new BaseEntity();
        OrganizationEntity organizationEntity = organizationRepository.findByCookie(cookie);
        if(organizationEntity!=null) {
            CourseEntity courseEntity = courseRepository.findOne(cid);
            if(courseEntity.getOrganizationid()==organizationEntity.getId()) {
                List<LessonsEntity> lessonsEntities = lessonsRepository.findBycourseId(cid);
                for (LessonsEntity lessonsEntity : lessonsEntities) {
                    lessonsRepository.delete(lessonsEntity.getId());
                }
                courseRepository.delete(cid);
                baseEntity.setStatus(0);
                return baseEntity;
            }else {
                baseEntity.setStatus(0);
                return baseEntity;
            }
        }else {
            baseEntity.setStatus(0);
            return baseEntity;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/deleteLessons")
    public BaseEntity deleteLessons(String cookie,int lid){
        BaseEntity baseEntity = new BaseEntity();
        LessonsEntity lessonsEntitie = lessonsRepository.findOne(lid);
        OrganizationEntity organizationEntity = organizationRepository.findByCookie(cookie);
        if(organizationEntity!=null) {
            if(lessonsEntitie.getCourseId()==organizationEntity.getId()){
                videoRepository.delete(lessonsEntitie.getVideoId());
                lessonsRepository.delete(lessonsEntitie);
                baseEntity.setStatus(0);
                return baseEntity;
            }
        }
        baseEntity.setStatus(204);
        return baseEntity;
    }
    @ResponseBody
    @RequestMapping(value = "/getCourseByOcookie")
    public List<CourseEntity> deleteLessons(String cookie){
        OrganizationEntity organizationEntity = organizationRepository.findByCookie(cookie);
        List<CourseEntity> courseEntities = courseRepository.findByOrganizationid(organizationEntity.getId());
        return courseEntities;
    }

    @ResponseBody
    @RequestMapping(value = "/getAllTeachers")
    public TeacherList getAllTeachers(String cookie){
        OrganizationEntity organizationEntity = organizationRepository.findByCookie(cookie);
        TeacherList teacherEntityList = new TeacherList();
        teacherEntityList.setTeacherEntities(teacherRepository.findOrderByOrganizationid(organizationEntity.getId()));
        return  teacherEntityList;
    }


}
