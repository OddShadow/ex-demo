package org.example.service;

import org.example.entity.UserInfo;

public interface UserInfoService {
    UserInfo findByUsername(String username);
}
