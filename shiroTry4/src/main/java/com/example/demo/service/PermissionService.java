package com.example.demo.service;

import com.example.demo.entity.Permission;
import com.example.demo.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

@Service
public class PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    public Set<String> findPermissionByUsername(String username){
        List<Permission> list = permissionMapper.findPermissionByUsername(username);
        Set<String> s = new HashSet<>();

        for (Permission permission : list) {
            s.add(permission.getPermissionName());
        }

        return s;
    }

    public String addPermission(Permission permission) {
        int i = permissionMapper.addPermission(permission);
        return i == 1 ? "success" : "fail";
    }
}
