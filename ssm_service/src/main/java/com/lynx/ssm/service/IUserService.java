package com.lynx.ssm.service;

import com.lynx.ssm.domain.Role;
import com.lynx.ssm.domain.UserInfo;

import java.util.List;

public interface IUserService {
    //查找所有用户
    List<UserInfo> findAll()throws Exception;

    void saveUser(UserInfo userInfo)throws Exception;

    UserInfo findByid(String id)throws Exception;

    List<Role> findOtherRoles(String userid)throws Exception;

    void addRoleToUser(String userId, String[] roleIds)throws Exception;
}
