package com.yang.tucao.web;

import com.yang.tucao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TucaoController {

    @Autowired
    private UserMapper userMapper;
}
