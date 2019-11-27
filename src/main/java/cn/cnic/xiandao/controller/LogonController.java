package cn.cnic.xiandao.controller;


import cn.cnic.xiandao.model.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Slf4j
public class LogonController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/")
    public String getIndex(){
        if(httpServletRequest.getSession() != null){
            return "redirect:/index.html";
        }
        return "login";
    }


    @PostMapping("/authentication")
    @ResponseBody
    public ResultVO authentication(@RequestBody Map<String,Object> map){
        ResultVO<Object> build = ResultVO.builder().build();
        log.info("authentication map : {}",map.toString());
        String userName = map.get("userName").toString();
        String password = map.get("password").toString();
        if("admin".equals(userName) && "123456".equals(password) ){
            build.setCode(0);
            return build;
        }
        if("许会鹏".equals(userName) && "123456".equals(password)){
            build.setCode(0);
            return build;
        }
        httpServletRequest.getSession().setAttribute("username",userName);
        build.setCode(-1);
        build.setMsg("账号或者密码错误");
        return  build;
    }

}
