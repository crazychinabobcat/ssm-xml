package com.lynx.ssm.service.impl;

import com.lynx.ssm.dao.IRoleDao;
import com.lynx.ssm.domain.Role;
import com.lynx.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    //查找所有角色
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    //增加角色
    @Override
    public void saveRole(Role role) throws Exception {
        roleDao.saveRole(role);
    }


    @Override
    public Role findByid(String roleId) throws Exception {
        return roleDao.findByid(roleId);
    }

    @Override
    public List<Role> findOtherPermission(String roleId) throws Exception {
        return roleDao.findOtherPermission(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId:permissionIds ){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
