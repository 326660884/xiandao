package cn.cnic.xiandao.dao;

import cn.cnic.xiandao.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserDao extends JpaRepository<User,Integer> {

    @Query(value = "select * from user_t u where u.user_name = ?1", nativeQuery = true)
    User selectByName(String username);
}
