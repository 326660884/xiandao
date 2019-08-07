package cn.cnic.xiandao.controller;


import cn.cnic.xiandao.model.Employee;
import cn.cnic.xiandao.model.ResultVO;
import cn.cnic.xiandao.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/")
    public String getIndex(){
        if(httpServletRequest.getSession() != null){
            return "redirect:/index.html";
        }
        return "login1";
    }


    @PostMapping("/authentication")
    public ResultVO authentication(String userName,String password){
        ResultVO<Object> build = ResultVO.builder().build();
        if("admin".equals("userName") && "123456".equals(password) ){
            build.setCode(0);
            return build;
        }
        if("许会鹏".equals("userName") && "123456".equals(password)){
            build.setCode(0);
            return build;
        }
        build.setCode(-1);
        build.setMsg("账号或者密码错误");
        return  build;
    }

}
