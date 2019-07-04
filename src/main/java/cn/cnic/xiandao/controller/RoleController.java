package cn.cnic.xiandao.controller;

import cn.cnic.xiandao.module.ISysRolePermission;
import cn.cnic.xiandao.module.ResutlJson;
import cn.cnic.xiandao.module.SysRole;
import cn.cnic.xiandao.service.RoleServiceImpl;
import cn.cnic.xiandao.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
@Slf4j
public class RoleController {

    @Resource
    RoleServiceImpl roleService;

    @Resource
    UserServiceImpl userService;


    @RequestMapping(value="/list")
    @ResponseBody
    @RequiresPermissions("role:view")
    public ResutlJson<SysRole> getRole(HttpServletRequest request, HttpServletResponse response)
    {

        int pageSize = 10;
        try {
            pageSize =  Integer.parseInt(request.getParameter("limit"));
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        int pageNumber=0 ;
        try {
            pageNumber =  Integer.parseInt(request.getParameter("page"))-1;
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        String strRole=request.getParameter("searchText")==null ? "": request.getParameter("searchText");
        String sortName=request.getParameter("sortName")==null ? "roleId": request.getParameter("sortName");
        String sortOrder=request.getParameter("sortOrder")==null ? "asc": request.getParameter("sortOrder");
        Sort sortLocal = new Sort(sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC: Sort.Direction.DESC,sortName);
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sortLocal);
        Page<SysRole> sysRolePage = roleService.findAllByRoleContains(strRole, pageable);
        ResutlJson<SysRole> ok = ResutlJson.OK();
        ok.setData(sysRolePage.getContent());
        ok.setCount((int)sysRolePage.getTotalElements());
        return ok;

    }



    @RequestMapping("/rlist")
//    @RequiresPermissions("user:view")
    public String list()
    {
        return "/user/roleList";
    }


    @RequestMapping(value="/roleAdd", method= RequestMethod.GET)
    @RequiresPermissions("role:add")
    public String toAdd(SysRole sysRole) {
        return "/user/roleAdd";
    }

    @RequestMapping(value="/roleAdd",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("role:add")
    public String save(@Valid SysRole sysRole, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "0";
        }
        if(sysRole.getCreateTime()==null)
            sysRole.setCreateTime(LocalDateTime.now());
        try {
            roleService.save(sysRole);
            return  "/user/rlist";
        }catch (Exception e)
        {
            e.printStackTrace();
            return "0";
        }
    }


    @RequestMapping("/checkRoleExists")
    @ResponseBody
    public Object checkRoleExists(@RequestParam String newRole, @RequestParam(required = false) Integer roleId, @RequestParam(required = false) String oldRole)
    {
        Map<String,Boolean> map = new HashMap<>();
        if(roleId==null)
        {
            boolean result = !roleService.checkRoleExists(newRole);
            map.put("valid",result);
        }
        else
        {
            boolean result = !roleService.checkRoleExists(oldRole,newRole);
            map.put("valid",result);
        }
        return map;
    }


    @RequestMapping(value = "/roleEdit/{id}")
    @RequiresPermissions("role:edit")
    public String edit(@PathVariable("id")Integer id, Map<String,Object> map)
    {
        SysRole sysRole = roleService.findById(id).orElse(new SysRole());
        map.put("sysRole",sysRole);
        return "/user/roleAdd";
    }

    @RequestMapping(value = "/roleDelete")
    @ResponseBody
    @RequiresPermissions("role:del")
    public Object delete(@RequestParam String roleIdList)
    {
        if(roleIdList==null || roleIdList.isEmpty())
        {
            return "0";
        }
        String[] sList = roleIdList.split(",");
        List<Integer> idList = new ArrayList<>();
        for (String s:sList )
        {
            if(s.equalsIgnoreCase("1"))
                return "0";
            idList.add(Integer.parseInt(s));

        }
        boolean result = roleService.deleteAllByRoleIdIn(idList);
        Map<String,String> map = new HashMap<>();
        if(result)
        {
            map.put("success","true");
            map.put("url","/user/rlist");
        }
        else
        {
            map.put("error","true");
        }

        return map;
    }

    @RequestMapping(value = "/plist/{roleId}")
    @RequiresPermissions("role:authorize")
    public String permissionList(@PathVariable("roleId")Integer roleId, Map<String, Object> map)
    {
        SysRole sysRole = roleService.findById(roleId).orElse(new SysRole());
        map.put("sysRole",sysRole);
        return "/user/sysPermission";
    }

    @RequestMapping("/getPermission/{roleId}")
    @ResponseBody
    @RequiresPermissions("role:authorize")
    public Object getRolePermission(@PathVariable("roleId")Integer roleId)
    {
        if(roleId==null)
            return null;

        List<ISysRolePermission> list = roleService.findSysRolePermissionByRoleId(roleId);
        return list;
    }

    //根据roleid授权
    @RequestMapping(value = "/toAuthorize")
    @ResponseBody
    @RequiresPermissions("role:authorize")
    public Object toAuthorize(Integer roleId,String permissionIdList)
    {
        if(roleId==1) return 0;
        Map<String,String> map = new HashMap<>();
        if(permissionIdList==null || permissionIdList.isEmpty())
        {
            try {
                roleService.clearAuthorization(roleId);
                map.put("success","true");
                map.put("url","/user/rlist");
                return map;
            }catch (Exception e)
            {
                e.printStackTrace();
                map.put("sucess","false");
                map.put("url","/user/rlist");
                return map;
            }
        }
        String[] sList = permissionIdList.split(",");
        List<Integer> idList = new ArrayList<>();
        for (String s:sList )
        {
            idList.add(Integer.parseInt(s));
        }

        try {
            roleService.grantAuthorization(roleId,idList);
            map.put("sucess","true");
            map.put("url","/user/rlist");

            return map;
        }catch (Exception e)
        {
            e.printStackTrace();
            map.put("sucess","false");
            map.put("url","/user/rlist");
            return map;
        }

    }

    @PostMapping(value = "/add")
    @ResponseBody
    public ResutlJson<?> insert(SysRole sysRole,String permissions){
        log.info("SysRole {}",sysRole.toString());
        log.info("SysRole-permissions {}",permissions);
        roleService.insertAndRelation(sysRole,permissions);
        return ResutlJson.OK();
    }



}
