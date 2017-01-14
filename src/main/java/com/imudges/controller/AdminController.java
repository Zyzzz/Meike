package com.imudges.controller;

import com.imudges.model.AdminEntity;
import com.imudges.model.OrganizationEntity;
import com.imudges.model.OrganizationList;
import com.imudges.repository.AdminRepository;
import com.imudges.repository.OrganizationRepository;
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
    AdminRepository adminRepository;
    @Autowired
    OrganizationRepository organizationRepository;

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
     *删除失败的情况没有写
     */
    @ResponseBody
    @RequestMapping(value = "/A_deleteOrganization")
    public AdminEntity A_deleteOrganization(int id){

        organizationRepository.delete(id);
        organizationRepository.flush();

        return adminEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/A_allOrganization")
    public OrganizationList A_allOrganization(){

        OrganizationList organizationList=new OrganizationList();
        organizationList.setOrganizationEntityList(organizationRepository.findAll());

        return organizationList;
    }
}
