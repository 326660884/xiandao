package cn.cnic.xiandao.service;

import cn.cnic.xiandao.dao.UserRepository;
import cn.cnic.xiandao.module.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class UserServiceImpl {

    @Resource
    private UserRepository userRepository;

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


    public List<IUserRole> findUserRoleByUserName(String userName) {
        return userRepository.findUserRoleByUserName(userName);

    }


    public List<IUserRole> findAllUserRoleByUserId(Integer userId) {
        return userRepository.findAllUserRoleByUserId(userId);
    }


    public List<ISysPermission> findUserRolePermissionByUserName(String userName) {
        return userRepository.findUserPermission(userName,null);
    }


    public Optional<User> findUserById(Integer userId) {
        return userRepository.findById(userId);
    }


    public User save(User user) {
        return userRepository.save(user);
    }


    public boolean checkUserExists(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user != null)
            return true;
        else
            return false;
    }


    public boolean checkUserExists2(String oldUserName, String newUserName) {
        User user = userRepository.findUserExist2(oldUserName, newUserName);

        if (user != null)
            return true;
        else
            return false;
    }


    public Page<User> findAllByUserNameContains(String userName, Pageable pageable) {
        return userRepository.findAllByUserNameContains(userName, pageable);
    }

    @Transactional
    public void deleteAllUserByUserIdList(List<Integer> userIdList) {
        userRepository.deleteAllUserRoleByUserIdList(userIdList);
        userRepository.deleteAllUserByUserIdList(userIdList);
    }

    @Transactional
    public void deleteAllUserRoleByUserIdList(List<Integer> userIdList) {
        userRepository.deleteAllUserRoleByUserIdList(userIdList);
    }

    @Transactional
    public void deleteAllUserRoleByUserId(Integer userId) {
        userRepository.deleteAllUserRoleByUserId(userId);
    }

    @Transactional
    public void grantUserRole(Integer userId, List<Integer> roleIdList) {
        userRepository.deleteAllUserRoleByUserId(userId);
        for (Integer roleId : roleIdList) {
            userRepository.insertUserRole(userId, roleId);
        }
    }

    public CopyOnWriteArrayList<ISysPermission> getNavs(String userName){
        return (CopyOnWriteArrayList)getNavs(userName,true);
    }

    /**
     *
     * @param userName
     * @param tag 是否包装成并发List
     * @return CopyOnWriteArrayList ro ArraryList
     */
    public List<ISysPermission> getNavs(String userName,boolean tag){
        if(tag){
            List<ISysPermission> allPermission = userRepository.findUserPermission(userName,null);
            CopyOnWriteArrayList<ISysPermission> iSysPermissions = new CopyOnWriteArrayList<>();
            iSysPermissions.addAll(allPermission);
            return iSysPermissions;
        }else{
            return userRepository.findUserPermission(userName,null);
        }

    }
}