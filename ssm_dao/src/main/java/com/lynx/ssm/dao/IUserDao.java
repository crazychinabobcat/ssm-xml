package com.lynx.ssm.dao;

import com.lynx.ssm.domain.Role;
import com.lynx.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {

    //查找所有用户
    List<UserInfo> findAll()throws Exception;

    void saveUser(UserInfo userInfo)throws Exception;

    UserInfo findByid(String id)throws Exception;

    List<Role> findOtherRoles(String userid)throws Exception;

    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId)throws Exception;
}
