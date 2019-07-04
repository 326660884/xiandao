package cn.cnic.xiandao.controller;

import cn.cnic.xiandao.module.*;
import cn.cnic.xiandao.service.PermissionService;
import cn.cnic.xiandao.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
@Slf4j
public class PermissionController{

    @Autowired
    private PermissionService permissionService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("permission/list")
    @ResponseBody
    private Object getPermissionByUserName(String username){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            user = new User();
        }
        if(StringUtils.isEmpty(user.getUserName())){//测试用
            user.setUserName(username);
        }
        List<SysPermission> list = permissionService.findPermissionByUserName(user.getUserName());
        ResutlJson<SysPermission> ok = ResutlJson.OK();
        ok.setData(list);
        ok.setCount(list.size());
        return ok;
    }

    /**
     * 权限树
     * @return ResutlJson
     */
    @RequestMapping("permission/tree")
    @ResponseBody
    public ResutlJson<?> createTree(){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            return ResutlJson.FAIL("用户名为空");
        }
        List<ISysPermission> navs = userService.getNavs(user.getUserName(),false);
        List<NavsPermission> data = permissionService.modelTree(navs, 0);
        ResutlJson<NavsPermission> ok = ResutlJson.OK();
        ok.setData(data);
        return ok;
    }

    @PostMapping("permission")
    @ResponseBody
    public ResutlJson<?> insertRole(HttpServletRequest request,SysRole role){

        String permissions = request.getParameter("permissions");
        return ResutlJson.OK(permissions);
    }
}
