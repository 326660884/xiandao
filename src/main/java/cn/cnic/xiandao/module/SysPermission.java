package cn.cnic.xiandao.module;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "sys_permission")
public class SysPermission {

    @Id
    @GenericGenerator(name="generator",strategy = "native")
    @GeneratedValue(generator = "generator")
    private Integer permissionId;//主键.

    @Column(nullable = false)
    private String permissionName;//名称.

    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;//资源类型，[menu|button]

    private String url;//资源路径.

    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view

    private Integer parentId; //父编号

    private String parentIds; //父编号列表

    private Integer level;//菜单层级，1（顶级）,2,3

    private Boolean available = Boolean.FALSE;
    //角色 -- 权限关系：多对多关系;
//    @ManyToMany
//    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    @Transient
    private List<SysRole> roles;


}
