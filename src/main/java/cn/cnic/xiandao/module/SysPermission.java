package cn.cnic.xiandao.module;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sys_permission")
@ToString
public class SysPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permissionId;//主键.

    @Column(nullable = false)
    private String permissionName;//名称.

    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;//资源类型，[menu|button]

    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view

    private Integer parentId; //父编号

    private Integer level;//菜单层级，1（顶级）,2,3

    private Boolean available;//可获得的

    private String href;//资源路径.

    private String fontFamily;
    private String icon;
    private Boolean isClose;
    private Boolean spread;
    private Boolean isCheck;

}
