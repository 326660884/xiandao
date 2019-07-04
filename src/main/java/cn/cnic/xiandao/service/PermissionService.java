package cn.cnic.xiandao.service;

import cn.cnic.xiandao.dao.PermissionRepository;
import cn.cnic.xiandao.module.ISysPermission;
import cn.cnic.xiandao.module.NavsPermission;
import cn.cnic.xiandao.module.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public List<SysPermission> findPermissionByUserName(String userName){
        return  permissionRepository.findPermissionByUserName(userName);
    }


    /**
     *
     * @param list 权限数组
     * @param parentId 根节点 id
     * @return
     */
    public List<NavsPermission> modelTree(List<ISysPermission> list, Integer parentId){
        List<NavsPermission> navsPermissions = new ArrayList<>();
        for (ISysPermission p:list) {
            if(p.getparent_id().equals(parentId)){
                NavsPermission<NavsPermission> newNode = new NavsPermission<>();
                newNode.setId(p.getPermission_Id());
                newNode.setTitle(p.getPermission_name());
                //它的ip是别人的父Id
                List<NavsPermission> children = modelTree(list,p.getPermission_Id());
                newNode.setChildren(children);
                navsPermissions.add(newNode);
            }
        }
        return navsPermissions;
    }

}
