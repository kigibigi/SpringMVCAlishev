package com.bmolc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

//    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");

//    @GetMapping("/hello")
//    public String helloPage(@RequestParam("name") String name,
//                            @RequestParam("surname") String surname) {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname) {

        System.out.printf("Hello %s %s!", name, surname);
        System.out.println();

        return "/first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "/first/goodbye";
    }
}
