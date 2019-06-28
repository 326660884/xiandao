package cn.cnic.xiandao.module;

/**
 * 用于UserRepository自定义返回实体用户与权限对应表
 */
public interface ISysPermission {

    Integer getUserId();
    String getUserName();
    Integer getPermissionId();
    String getPermission();
    String getPermissionName();

}
