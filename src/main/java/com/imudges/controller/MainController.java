package com.imudges.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/12/8.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/O_index", method = RequestMethod.GET)
    public String O_index() {
        return "O_index";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String About_us() {
        return "about";
    }

}