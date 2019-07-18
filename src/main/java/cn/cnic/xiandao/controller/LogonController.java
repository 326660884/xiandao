package cn.cnic.xiandao.controller;


import cn.cnic.xiandao.model.Employee;
import cn.cnic.xiandao.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class LogonController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    BaseServiceImpl<BaseMapper<Employee>,Employee> service;


    @GetMapping("/login")
    public String getLogin(){
        return "login1";
    }



}
