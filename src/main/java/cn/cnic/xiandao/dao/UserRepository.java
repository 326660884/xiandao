package cn.cnic.xiandao.dao;

import cn.cnic.xiandao.module.ISysPermission;
import cn.cnic.xiandao.module.IUserRole;
import cn.cnic.xiandao.module.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserName(String userName);

    Page<User> findAllByUserNameContains(String userName, Pageable pageable);

    //排除现有用户的情况下，判断新用户是否存在
    @Query(value="select * from user where userName<> ?1 and userName=?2",nativeQuery = true)
    User findUserExist2(String oldUserName, String newUserName);

    //根据userid列表删除所有用户
    @Modifying
    @Query(value="delete from user where userId in (?1)",nativeQuery = true)
    void deleteAllUserByUserIdList(List<Integer> userIdList);

    //根据userid删除用户角色关联表里的记录
    @Modifying
    @Query(value="delete from sysuserrole where userId in (?1)",nativeQuery = true)
    void deleteAllUserRoleByUserIdList(List<Integer> userIdList);

    //根据userid删除用户角色关联表里的记录
    @Modifying
    @Query(value="delete from sysuserrole where userId = ?1",nativeQuery = true)
    void deleteAllUserRoleByUserId(Integer userId);

    //新增用户和角色关联记录
    @Modifying
    @Query(value="insert into sysuserrole(userId,roleId) VALUES(?1,?2)",nativeQuery = true)
    void insertUserRole(Integer userId, Integer roleId);

    //根据用户名获取用户所具备的角色列表
    @Query(value="SELECT   a.userid, a.user_Name, c.role_Id, c.role, c.description\n" +
                    "FROM\n" +
                    "    user a\n" +
                    "        INNER JOIN\n" +
                    "    sys_user_role b ON a.userid = b.user_Id\n" +
                    "        INNER JOIN\n" +
                    "    sys_role c ON b.role_Id = c.role_Id AND c.available = 1\n" +
                    "WHERE\n" +
                    "    a.user_Name =?1",
            countQuery = "select count(*) from user a \n" +
                    "inner join sys_user_role b on a.userId = b.user_Id\n" +
                    "inner join sys_role c on b.role_Id=c.role_Id and c.available=1\n" +
                    "where a.user_Name=?1",
            nativeQuery = true)
    List<IUserRole> findUserRoleByUserName(String userName);

    //根据用户id，列出所有角色，包括该用户不具备的角色，该用户不具备角色的时候，userid和username为null，可以做业务判断
    @Query(value="select a.roleId,a.role,a.description,c.userId,c.userName from sysrole a\n" +
            "left join sysuserrole b on a.roleId=b.roleId and a.available=1 and b.userId=?1\n" +
            "left join user c on c.userId=b.userId;",
            countQuery = "select count(*) from SysRole a\n" +
                    "left join sysuserrole b on a.roleId=b.roleId and a.available=1 and b.userId=?1\n" +
                    "left join user c on c.userId=b.userId;",
            nativeQuery = true)
    List<IUserRole> findAllUserRoleByUserId(Integer userId);

    @Query(value = "select version()",nativeQuery = true)
    String getDbVersion();

    /**
     * 根据用户查询权限列表
     * @param username 用户名
     * @param type 权限类型
     * @return
     */
    @Query(value = "SELECT a.userId,a.user_Name,d.* \n" +
            "FROM \n" +
            "    user a INNER JOIN sys_user_role b ON a.userId = b.user_Id\n" +
            "INNER JOIN sys_role_permission c ON b.role_Id = c.role_Id\n" +
            "INNER JOIN sys_permission d ON c.permission_Id = d.permission_Id\n" +
            "WHERE \n" +
            "    a.user_Name = ?1",
            countQuery = "SELECT count(1) \n" +
                    "FROM \n" +
                    "    user a INNER JOIN sys_user_role b ON a.userId = b.user_Id\n" +
                    "INNER JOIN sys_role_permission c ON b.role_Id = c.role_Id\n" +
                    "INNER JOIN sys_permission d ON c.permission_Id = d.permission_Id\n" +
                    "WHERE \n" +
                    "    a.user_Name = ?1 and if(?2 != '',resource_type = ?2, 1=1)",
            nativeQuery = true)
    List<ISysPermission> findUserPermission(String username,String type);

}
