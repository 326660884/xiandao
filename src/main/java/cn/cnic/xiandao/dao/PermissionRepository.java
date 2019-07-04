package cn.cnic.xiandao.dao;

import cn.cnic.xiandao.module.ISysPermission;
import cn.cnic.xiandao.module.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PermissionRepository extends JpaRepository<SysPermission,Integer> {

    @Query(value="SELECT d.*\n" +
            "FROM\n" +
            "    user a INNER JOIN sys_user_role b ON a.userId = b.user_Id\n" +
            "\tINNER JOIN sys_role_permission c ON b.role_Id = c.role_Id\n" +
            "\tINNER JOIN sys_permission d ON c.permission_Id = d.permission_Id\n" +
            "WHERE\n" +
            "    a.user_Name = ?1",
            nativeQuery = true)
    List<SysPermission> findPermissionByUserName(String userName);


}
