package com.example.sudhar.springbootscheduler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AppController {

    @RequestMapping("/**")
    public String handler(ModelMap map, HttpServletRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        map.addAttribute("uri", request.getRequestURI());
        map.addAttribute("user", auth.getName());
        map.addAttribute("roles", auth.getAuthorities());

        return "app";
    }
}
