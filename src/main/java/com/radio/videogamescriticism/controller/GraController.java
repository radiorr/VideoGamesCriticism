package com.radio.videogamescriticism.controller;

import com.radio.videogamescriticism.service.VgcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GraController {
    @Autowired
    private VgcUserService VgcUserService;

    @RequestMapping("/gra")
    public String gra(HttpServletRequest request, HttpServletResponse response) {

        return "gra";
    }
}
