package org.example.service.impl;

import org.example.dao.UserInfoDao;
import org.example.entity.UserInfo;
import org.example.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }

}