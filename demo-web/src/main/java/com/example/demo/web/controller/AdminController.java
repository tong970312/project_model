package com.example.demo.web.controller;

import com.example.demo.biz.AdminService;
import com.example.demo.dao.entity.User;
import com.example.demo.testBean.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {


    @Autowired
    AdminService adminService;
    //读取配置文件的值
    @Value("${email}")
    String email; //  System.out.println(email); --> 1274961697@qq.com
    @Autowired
    TestBean testBean;

    @GetMapping("/get")
    public User get(){
        return adminService.print();
    }


}
