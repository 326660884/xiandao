package cn.cnic.xiandao.module;

/**
 * 用于UserRepository自定义返回实体用户与权限对应表
 */
public interface ISysPermission {

    Integer getUserId();
    String getUserName();
    Integer getPermission_Id();
    String getPermission();
    String getPermission_name();

    Integer getLevel();
    Integer getparent_id();
    String getFont_Family();
    String getIcon();
    String getHref();
    Boolean getIs_close();
    Boolean getSpread();
    Boolean getIs_Check();
}
