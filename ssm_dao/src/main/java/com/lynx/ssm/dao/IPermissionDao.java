package com.lynx.ssm.dao;

import com.lynx.ssm.domain.Permission;

import java.util.List;

public interface IPermissionDao {
    List<Permission> findAll()throws Exception;

    void save(Permission permission)throws Exception;
}
