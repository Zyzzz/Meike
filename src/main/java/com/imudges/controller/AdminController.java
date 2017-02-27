package com.imudges.controller;

import com.imudges.model.*;
import com.imudges.repository.*;
import com.imudges.utils.SHA256Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/14.
 */
@Controller
public class AdminController {
    private AdminEntity adminEntity;

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    PictureRepository pictureRepository;
    @Autowired
    LandcViewRepository landcViewRepository;
    @Autowired
    LessonsinformationRepository lessonsinformationRepository;

    @Autowired
    LessonsRepository lessonsRepository;

    /*
     *管理员登录
     */
    @RequestMapping(value = "/Asignin", method = RequestMethod.GET)
    public String AdminLogin(){
        return "A_sign-in";
    }
    @ResponseBody
    @RequestMapping(value = "/Alogin")
    public AdminEntity Alogin(String email, String password){
        adminEntity = adminRepository.findByEmail(email);
        if(adminEntity==null){
            adminEntity = new AdminEntity();
            adminEntity.setStatus(100);
        }
        else if(!adminEntity.getPassword().equals(password)){
            adminEntity = new AdminEntity();
            adminEntity.setStatus(101);
        }
        else {
            String cookie = SHA256Test.SHA256Encrypt(email+new Date().toString());
            adminEntity.setCookie(cookie);
            adminRepository.saveAndFlush(adminEntity);
            adminEntity.setStatus(0);
        }
        return adminEntity;
    }

    /*
     *添加Organization
     */
    @RequestMapping(value = "/addOrganization",method = RequestMethod.POST)
    public String addOrganization()
    {
        return "addOrganization";
    }




    @ResponseBody
    @RequestMapping(value = "/A_addOrganization")
    public OrganizationEntity A_addOrganization(String name,String information,String address,double rank,String email,String password){

        OrganizationEntity organizationEntity=organizationRepository.findByEmail(email);
        if (organizationEntity==null){
            organizationEntity=new OrganizationEntity();
            organizationEntity.setName(name);
            organizationEntity.setInformation(information);
            organizationEntity.setAddress(address);
            organizationEntity.setRank(rank);
            organizationEntity.setEmail(email);
            organizationEntity.setPassword(password);
            organizationRepository.saveAndFlush(organizationEntity);
            organizationEntity.setStatus(0);
        }
        else {
            organizationEntity=new OrganizationEntity();
            organizationEntity.setStatus(102);
        }

        return organizationEntity;
    }

    /*
     *删除Organization
     */
    @ResponseBody
    @RequestMapping(value = "/A_deleteOrganization")
    public BaseEntity A_deleteOrganization(int id){
        BaseEntity baseEntity = new BaseEntity();
        try {
            organizationRepository.delete(id);
            organizationRepository.flush();
            baseEntity.setStatus(0);
            return baseEntity;
        }catch (Exception e){
            baseEntity.setStatus(204);
            return baseEntity;
        }
    }

    /*
     *查看所有的Organization
     */
    @ResponseBody
    @RequestMapping(value = "/A_allOrganization")
    public OrganizationList A_allOrganization(){

        OrganizationList organizationList=new OrganizationList();
        organizationList.setOrganizationEntityList(organizationRepository.findAll());
        organizationList.setStatus(0);
        return organizationList;
    }

    /*
     *查看所有课程
     */
    @ResponseBody
    @RequestMapping(value = "/A_allCourse")
    public CourseListEntity A_allCourse(){

        List<CourseEntity> courseEntities = courseRepository.findAll();
        List<PictureEntity> pictureEntities  = pictureRepository.findByPattern(1);
        CourseInformationEntity courseInformationEntity = new CourseInformationEntity();
        List<CourseInformationEntity> courseInformationEntities = new ArrayList<>();
        CourseListEntity courseListEntity = new CourseListEntity();
        for(CourseEntity courseEntity:courseEntities){
            for(PictureEntity pictureEntity :pictureEntities){
                if(courseEntity.getId()==pictureEntity.getOtherid()){
                    courseInformationEntity.setCourseEntity(courseEntity);
                    courseInformationEntity.setPictureEntity(pictureEntity);
                    courseInformationEntities.add(courseInformationEntity);
                }
            }
        }
        courseListEntity.setStatus(0);
        courseListEntity.setCourseInformationEntities(courseInformationEntities);

        return  courseListEntity;
    }

    /*
     *查看课程的内容lessons
     */
    @ResponseBody
    @RequestMapping(value = "/A_lessonsOfCourse")
    public List A_lessonsOfCourse(int cid)
    {
        return landcViewRepository.findBycid(cid);
    }

    /*
     *查看lesson的信息
     */
    @ResponseBody
    @RequestMapping(value = "/A_lessonInformation")
    public LessonsinformationEntity A_lessonInformation(int lid){
        return lessonsinformationRepository.findOne(lid);
    }

    /*
     *删除course
     */
    @ResponseBody
    @RequestMapping(value = "/A_deleteCourse")
    public BaseEntity A_deleteCourse(int cid){
        BaseEntity baseEntity = new BaseEntity();
        List<LessonsEntity> lessonsEntities = lessonsRepository.findBycourseId(cid);
        for(LessonsEntity lessonsEntity : lessonsEntities){
            lessonsRepository.delete(lessonsEntity.getId());
        }
        courseRepository.delete(cid);
        baseEntity.setStatus(0);
        return baseEntity;
    }

    /*
     *删除课程的某节课lesson
     * 需要在确定一下
     */
    @ResponseBody
    @RequestMapping(value = "/A_deleteLesson")
    public BaseEntity A_deleteLesson(int lid){
        BaseEntity baseEntity = new BaseEntity();
        lessonsRepository.delete(lid);
        baseEntity.setStatus(0);
        return baseEntity;
    }

    /*
     *查看所有老师
     */
//    @ResponseBody
//    @RequestMapping(value = "/A_allTeacher")
//    public List<TeacherEntity> A_allTeacher(){
//        List<TeacherEntity> teacherEntityList=teacherRepository.findAll();
//        return teacherEntityList;
//    }

    /*
     *查看老师的课程
     */


}
