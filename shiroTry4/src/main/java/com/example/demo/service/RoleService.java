package com.example.demo.service;

import com.example.demo.entity.Permission;
import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public Set<String> findRoleByUsername(String username){
        List<Role> list = roleMapper.findRoleByUsername(username);
        Set<String> s = new HashSet<>();

        for (Role role : list) {
            s.add(role.getRoleName());
        }

        return s;
    }

    public String addRole(Role role) {
        int i = roleMapper.addRole(role);
        return i == 1 ? "success" : "fail";
    }
}
