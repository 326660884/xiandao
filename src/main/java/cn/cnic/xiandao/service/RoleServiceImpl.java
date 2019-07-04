package cn.cnic.xiandao.service;

import cn.cnic.xiandao.dao.RoleRepository;
import cn.cnic.xiandao.module.ISysRolePermission;
import cn.cnic.xiandao.module.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl {

    @Resource
    RoleRepository roleRepository;


    public Page<SysRole> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }


    public Optional<SysRole> findById(Integer roleId) {
        return roleRepository.findById(roleId);
    }


    public Page<SysRole> findAllByRoleContains(String role, Pageable pageable) {
        return roleRepository.findAllByRoleContains(role,pageable);
    }


    public SysRole save(SysRole sysRole) {
        return roleRepository.save(sysRole);
    }


    public boolean checkRoleExists(String role) {
        SysRole sysRole = roleRepository.findSysRoleByRole(role);
        if(sysRole!=null)
            return true;
        else
            return false;
    }


    public boolean checkRoleExists(String oldRole, String newRole) {
        SysRole sysRole = roleRepository.findSysRoleExists2(oldRole,newRole);
        if(sysRole!=null)
            return true;
        else
            return false;
    }

    //删除角色权限和角色
    @Transactional

    public boolean deleteAllByRoleIdIn(List<Integer> roleIdList) {
        try {
            for(Integer roleId:roleIdList)
            {
                roleRepository.deleteRolePermission(roleId);
            }
            roleRepository.deleteAllByRoleIdList(roleIdList);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }


    public List<ISysRolePermission> findSysRolePermissionByRoleId(Integer roleId) {
        return roleRepository.findSysRolePermissionByRoleId(roleId);
    }

    //授权前先清除原角色权限，然后重新新增授权
    @Transactional
    public void grantAuthorization(Integer roleId, List<Integer> permissionList) {
        roleRepository.deleteRolePermission(roleId);
        for(Integer permissionId:permissionList)
        {
            roleRepository.insertRolePermission(roleId,permissionId);
        }
    }

    @Transactional
    public void clearAuthorization(Integer roleId) {
        roleRepository.deleteRolePermission(roleId);
    }

    /**
     *
     * @param sysRole
     * @param permissions
     * @return sysRole id
     */
    @Transactional
    public SysRole insertAndRelation(SysRole sysRole, String permissions) {
        SysRole nowRole = roleRepository.save(sysRole);
        if(nowRole.getRoleId() != null){

        }
        return nowRole;
    }
}
