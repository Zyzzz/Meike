package com.imudges.controller;

import com.imudges.model.OrganizationEntity;
import com.imudges.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cyy on 2016/12/10.
 */
@Controller
public class OrganizationController {
    @Autowired
    OrganizationRepository organizationRepository;


    @RequestMapping(value = "/Osignin", method = RequestMethod.GET)
    public String OrganizationLogin(){
        return "O_sign-in";


    }

    @RequestMapping(value = "/Ologin", method = RequestMethod.GET)
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


}
