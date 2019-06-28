package cn.cnic.xiandao.controller;


import cn.cnic.xiandao.config.PasswordHelper;
import cn.cnic.xiandao.module.User;
import cn.cnic.xiandao.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class LogonController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PasswordHelper passwordHelper;

    @GetMapping("/login")
    public String getLogin(){
        return "login1";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ModelAndView Login(User user){
        log.info("login IP = [{}],login user = {}",httpServletRequest.getLocalAddr(),user.toString());
        ModelAndView mv = new ModelAndView();
        if (user.getUserName() == null || user.getPassword() == null){
            mv.addObject("msg","用户名或密码不能为空");
            mv.setViewName("login1");
            return mv;
        }
        String msg = null;
        // 1、获取Subject实例对象
        Subject currentUser = SecurityUtils.getSubject();

//        // 2、判断当前用户是否登录
//        if (currentUser.isAuthenticated() == false) {
//
//        }

        // 3、将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());

        // 4、认证
        try {
            currentUser.login(token);// 传到MyAuthorizingRealm类中的方法进行认证
            Session session = currentUser.getSession();
            session.setAttribute("userName", user.getName());
        }catch (UnknownAccountException e) {
            e.printStackTrace();
            msg = "UnknownAccountException -- > 账号不存在：";
        }
        catch (IncorrectCredentialsException e)
        {
            msg = "IncorrectCredentialsException -- > 密码不正确：";
        }
        catch (AuthenticationException e) {
            e.printStackTrace();
            msg="用户验证失败";
        }

        if(StringUtils.isEmpty(msg)){
            mv.setViewName("index");
        }else {
            mv.addObject("msg",msg);
            mv.setViewName("login1");
        }
        return mv;

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

    @RequestMapping("/unauthc")
    public String unauthc(){
        return "unauthc";
    }

//    @RequestMapping(value = "/pages/{fileName}/{entity}",method = RequestMethod.GET)
//    public String page(@PathVariable("fileName") String fileName, @PathVariable("entity")String entity){
//        log.info("pages----------");
//
//        return "pages/"+fileName+"/"+entity.replace(".html","");
//    }

}
