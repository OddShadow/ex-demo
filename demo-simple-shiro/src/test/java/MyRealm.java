import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    // 模拟数据库数据
    Map<String, Object> dataBaseMap = new HashMap<>(16);
    {
        super.setName("myRealm"); // 设置自定义Realm的名称，取什么无所谓..
        dataBaseMap.put("userName", "test02-rick");
        dataBaseMap.put("password", "123456");
        dataBaseMap.put("roles", new String[]{"admin", "test"});
        dataBaseMap.put("permissions", new String[]{"user:delete", "user:add"});
    }
    // 1. 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1.从主体传过来的认证信息中，获得用户名
        String userName = (String) token.getPrincipal();
        // 2.通过用户名到数据库中获取凭证并校验
        String password = getPasswordByUserName(userName);
        // 在这里校验
        // 如果身份认证验证成功，返回一个AuthenticationInfo实现
        return new SimpleAuthenticationInfo(userName, password, getName());
    }
    // 2. 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        // 从数据库获取角色和权限数据
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(getRolesByUserName(userName));
        simpleAuthorizationInfo.setStringPermissions(getPermissionsByUserName(userName));
        // 在这里校验
        // 如果身份认证验证成功，返回一个AuthenticationInfo实现
        return simpleAuthorizationInfo;
    }
    // 模拟从数据库取密码凭证的过程
    private String getPasswordByUserName(String userName) {
        return (String) dataBaseMap.get("password");
    }
    // 模拟从数据库中获取角色数据
    private Set<String> getRolesByUserName(String userName) {
        return new HashSet<>(Arrays.asList((String[]) dataBaseMap.get("roles")));
    }
    // 模拟从数据库中获取权限数据
    private Set<String> getPermissionsByUserName(String userName) {
        return new HashSet<>(Arrays.asList((String[]) dataBaseMap.get("permissions")));
    }
}