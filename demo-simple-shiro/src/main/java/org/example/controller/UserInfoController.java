package org.example.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.entity.UserInfo;
import org.example.service.UserInfoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserInfoController {

    @Resource
    UserInfoService userInfoService;

    /**
     * 按username账户从数据库中取出用户信息
     */
    @GetMapping("/userList")
    @RequiresPermissions("userInfo:view") // 权限管理
    public UserInfo findUserInfoByUsername(@RequestParam String username) {
        return userInfoService.findByUsername(username);
    }

    /**
     * 简单模拟从数据库添加用户信息成功
     */
    @PostMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String addUserInfo() {
        return "addUserInfo success!";
    }

    /**
     * 简单模拟从数据库删除用户成功
     */
    @DeleteMapping("/userDelete")
    @RequiresPermissions("userInfo:delete")
    public String deleteUserInfo() {
        return "deleteUserInfo success!";
    }
}