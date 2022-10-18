package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

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
public class SysRole {

    @Id
    @GeneratedValue
    private Long id; // 主键

    private String name; // 角色名称,如 admin/user

    private String description; // 角色描述,用于UI显示

    // 角色 -- 权限关系：多对多
    @JsonIgnoreProperties(value = {"roles"})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission",
            joinColumns = {@JoinColumn(name = "roleId")},
            inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<SysPermission> permissions;

    // 用户 -- 角色关系：多对多
    @JsonIgnoreProperties(value = {"roles"})
    @ManyToMany
    @JoinTable(name = "SysUserRole",
            joinColumns = {@JoinColumn(name = "roleId")},
            inverseJoinColumns = {@JoinColumn(name = "uid")})
    private List<UserInfo> userInfos;// 一个角色对应多个用户

}
