package cn.cnic.xiandao.module;

/**
 * 角色权限对照表，列出全部权限，没有权限的role和roleId为null
 */
public interface ISysRolePermission {
    Integer getRoleId();
    String getRole();
    Integer getPermissionId();
    String getPermission();
    String getPermissionName();
    Integer getParentId();
}
