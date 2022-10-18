package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class UserInfo {

    @Id
    @GeneratedValue
    private Long id; // 主键

    @Column(unique = true)
    private String username; // 登录账户 唯一

    private String name; // 名称(匿名或真实姓名),用于UI显示

    private String password; // 密码

    private String salt; // 加密盐

    @JsonIgnoreProperties(value = {"userInfos"})
    @ManyToMany(fetch = FetchType.EAGER) // 立即从数据库中进行加载数据
    @JoinTable(name = "SysUserRole",
            joinColumns = @JoinColumn(name = "uid"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<SysRole> roles; // 一个用户具有多个角色
}
