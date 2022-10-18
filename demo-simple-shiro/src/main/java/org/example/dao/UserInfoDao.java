package org.example.dao;

import org.example.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
}
