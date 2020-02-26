package com.lynx.ssm.service.impl;

import com.lynx.ssm.dao.IUserDao;
import com.lynx.ssm.domain.Role;
import com.lynx.ssm.domain.UserInfo;
import com.lynx.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;


    @Override
    public List<UserInfo> findAll()throws Exception {
        return userDao.findAll();
    }

    @Override
    public void saveUser(UserInfo userInfo) throws Exception {
       userDao.saveUser(userInfo);
    }

    @Override
    public UserInfo findByid(String id) throws Exception {
        return userDao.findByid(id);
    }

    @Override
    public List<Role> findOtherRoles(String userid) throws Exception {
        return userDao.findOtherRoles(userid);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds)throws Exception {
        for (String  roleId:roleIds){
            userDao.addRoleToUser(userId,roleId);
        }
    }
}
