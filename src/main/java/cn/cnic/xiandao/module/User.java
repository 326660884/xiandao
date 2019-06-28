package cn.cnic.xiandao.module;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "user")
public class User {
    /**
     * 密码盐. 重新对盐重新进行了定义，用户名+salt，这样就不容易被破解，可以采用多种方式定义加盐
     * @return
     */
    public String getCredentialsSalt() {
        return this.userName+this.salt;
    }



    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Integer userid;

    @Column(name="user_name",length = 20)
    private String userName;

    @Column(nullable = false)
    private String name;//名称（昵称或者真实姓名，根据实际情况定义）

    @Column(name = "password",length = 32)
    private String password;

    @Column(name = "salt",length = 16)
    private String salt;

    @Column
    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.

//    @ManyToMany(fetch = FetchType.EAGER)//立即从数据库中进行加载数据;
//    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
//    private List<SysRole> roles;

    @Transient
    private List<IUserRole> roleList;// 一个用户具有多个角色

    @Transient
    private List<ISysPermission> permissionList;//用户的权限

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createTime;//创建时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiredDate;//过期日期

    private String email;

    private String tel;

}
