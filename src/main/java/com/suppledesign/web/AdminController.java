package com.suppledesign.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
class AdminController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    String helloAdmin() {
        return "admin";
    }
}
