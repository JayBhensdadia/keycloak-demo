package com.jb.keycloak_demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("/user")
    public String helloUser(){
        return "Hello User";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyRole('admin', 'super-admin')")
    public String helloAdmin(){
        return "Hello Admin";
    }


    @GetMapping("/super-admin")
    @PreAuthorize("hasRole('super-admin')")
    public String helloSuperAdmin(){
        return "Hello Super Admin";
    }


}
