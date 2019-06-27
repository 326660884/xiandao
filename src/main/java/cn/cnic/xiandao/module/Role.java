package cn.cnic.xiandao.module;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role_t")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role",length = 8)
    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission_t", joinColumns = { @JoinColumn(name = "rid") }, inverseJoinColumns = {
            @JoinColumn(name = "pid") })
    private List<Permission> permissions;

    @ManyToMany
    @JoinTable(name = "user_role_t", joinColumns = { @JoinColumn(name = "rid") }, inverseJoinColumns = {
            @JoinColumn(name = "uid") })
    private List<User> users;
}
