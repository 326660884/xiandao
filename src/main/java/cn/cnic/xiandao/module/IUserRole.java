package cn.cnic.xiandao.module;

/**
 * 用于UserRepository自定义返回实体 用户与角色对应表
 */
public interface IUserRole {
    Integer getUserId();
    String getUserName();
    Integer getRoleId();
    String getRole();
    String getDescription();
}
