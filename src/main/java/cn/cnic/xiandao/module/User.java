package cn.cnic.xiandao.module;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "user_t")
public class User {

    public String getCredentialsSalt() {
        return username + salt + salt;
    }

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    @Column(name="user_name",length = 20)
    private String username;

    @Column(name = "password",length = 32)
    private String password;

    @Column(name = "salt",length = 16)
    private String salt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_t", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns = {
            @JoinColumn(name = "rid") })
    private List<Role> roles;

}
