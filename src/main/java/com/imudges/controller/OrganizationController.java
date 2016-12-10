package com.imudges.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cyy on 2016/12/10.
 */
@Controller
public class OrganizationController {
    @RequestMapping(value = "/Osignin", method = RequestMethod.GET)
    public String OrganizationLogin(){
        return "O_sign-in";
    }
}
