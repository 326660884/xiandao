package cn.cnic.xiandao.service;

import cn.cnic.xiandao.dao.UserDao;
import cn.cnic.xiandao.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int add(String name,String password){
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        User save = userDao.save(user);
        return save.getId();
    }


    public List<User> getAllUsers() {
        List<User> users = userDao.findAll();
        return users;
    }

    public User findUserByName(String username) {
        return userDao.selectByName(username);
    }
}
