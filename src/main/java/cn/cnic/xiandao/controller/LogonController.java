package cn.cnic.xiandao.controller;


import cn.cnic.xiandao.config.PasswordHelper;
import cn.cnic.xiandao.module.User;
import cn.cnic.xiandao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class LogonController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordHelper passwordHelper;

    @RequestMapping("login")
    public String Login(User user){
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            log.warn(ice.getMessage());
            return "login1";
        } catch (UnknownAccountException uae) {
            log.warn(uae.getMessage());
            return "login1";
        }

        User user2 = userService.findUserByName(user.getUsername());
        subject.getSession().setAttribute("user", user2);
        return "index";
    }

    @RequestMapping("/")
    public String home(String msg){
        log.debug("other:{}",msg);
        Object username = httpServletRequest.getSession().getAttribute("user");
        if(username == null){
            return "login1";
        }
        return "index";
    }

//    @RequestMapping(value = "/pages/{fileName}/{entity}",method = RequestMethod.GET)
//    public String page(@PathVariable("fileName") String fileName, @PathVariable("entity")String entity){
//        log.info("pages----------");
//
//        return "pages/"+fileName+"/"+entity.replace(".html","");
//    }

}
