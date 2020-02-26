package com.lynx.ssm.dao;


import com.lynx.ssm.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRoleDao {

    List<Role> findAll()throws Exception;

    void saveRole(Role role)throws Exception;

    Role findByid(String roleId)throws Exception;

    List<Role> findOtherPermission(String roleId)throws Exception;

    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId)throws Exception;
}
