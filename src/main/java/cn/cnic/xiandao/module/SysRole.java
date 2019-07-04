package cn.cnic.xiandao.module;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sys_Role")
@Data
@ToString
public class SysRole  {

    @Id
    @GenericGenerator(name="generator",strategy = "native")
    @GeneratedValue(generator = "generator")
    private Integer roleId; // 编号

    @Column(nullable = false, unique = true)
    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:sys_role_permission

    private String description; // 角色描述,UI界面显示使用

    private Boolean available = Boolean.TRUE; // 是否可用,如果不可用将不会添加给用户

    //    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createTime;//创建时间
    //    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiredDate;//过期日期

    //角色 -- 权限关系：多对多关系;
//    @ManyToMany(fetch= FetchType.EAGER)
//    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
//    private List<SysPermission> permissions;
//
//    用户 - 角色关系定义;
//    @ManyToMany
//    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="userId")})
//    private List<User> users;// 一个角色对应多个用户

//    @Transient
//    private List<ISysRolePermission> permissions;

}
