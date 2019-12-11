package com.example.demo.biz.impl;

import com.example.demo.biz.AdminService;
import com.example.demo.dao.entity.User;
import com.example.demo.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl  implements AdminService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User print() {
        return userRepository.selectByPrimaryKey(1);
    }
}
