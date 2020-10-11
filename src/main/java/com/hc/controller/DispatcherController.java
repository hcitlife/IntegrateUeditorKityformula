package com.hc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DispatcherController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/demo1")
    public String demo1() {
        return "demo1";
    }

    @RequestMapping("/demo2")
    public String demo2() {
        return "demo2";
    }

    @RequestMapping("/demo3")
    public String demo3() {
        return "demo3";
    }
}
