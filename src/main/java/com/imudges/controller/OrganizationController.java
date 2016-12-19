package com.imudges.controller;

import com.imudges.model.BaseEntity;
import com.imudges.model.OrganizationEntity;
import com.imudges.model.TeacherEntity;
import com.imudges.repository.OrganizationRepository;
import com.imudges.repository.TeacherRepository;
import com.imudges.utils.MailSender;
import com.imudges.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cyy on 2016/12/10.
 */
@Controller
public class OrganizationController {
    private TeacherEntity teacherEntity;
    private  OrganizationEntity organizationEntity;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private TeacherRepository teacherRepository;



    @RequestMapping(value = "/Osignin", method = RequestMethod.GET)
    public String OrganizationLogin(){
        return "O_sign-in";
    }
    @ResponseBody
    @RequestMapping(value = "/Ologin")
    public OrganizationEntity Ologin(String email,String password){
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
    public BaseEntity sendEmail(HttpServletRequest request, String cookie) {

        organizationEntity=organizationRepository.findByCookie(cookie);
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
    }

    @ResponseBody
    @RequestMapping(value = "/Change_Password")
    public BaseEntity ChangePasw(String verifyCode,String cookie,String newpassword){
        BaseEntity baseEntity=new BaseEntity();
        organizationEntity=organizationRepository.findByCookie(cookie);
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
    @RequestMapping(value = "/Add_teacher")
    public TeacherEntity AddTeacher(String cookie,String name,String phone){
        teacherEntity=new TeacherEntity();
        organizationEntity=organizationRepository.findByCookie(cookie);
        teacherEntity.setName(name);
        teacherEntity.setOrganizatioid(organizationEntity.getId());
        teacherEntity.setName(phone);
        teacherEntity.setStatus(0);
        teacherRepository.saveAndFlush(teacherEntity);
        return teacherEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/Delete_teacher")
    public BaseEntity DeleteTeacher(String index){
        BaseEntity baseEntity=new BaseEntity();
        return baseEntity;
    }

}
