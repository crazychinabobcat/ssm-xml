package com.lynx.ssm.service;

import com.lynx.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll()throws Exception;

    void saveRole(Role role)throws Exception;

    Role findByid(String roleId)throws Exception;

    List<Role> findOtherPermission(String roleId)throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds)throws Exception;
}
