import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;


public class MainTest {

    @Test
    public void mainTest() {
        test01();
//        test02();
    }

    // 简单的权限认证和角色判断
    private void test01() {
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        // 在方法开始前添加一个用户
        simpleAccountRealm.addAccount("test01-rick", "123456");
        // 在方法开始前添加一个用户,让它具备admin和user两个角色
        simpleAccountRealm.addAccount("test01-tom", "123456", "admin", "test");
        // 1.构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);
        // 2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager); // 设置SecurityManager环境
        Subject subject = SecurityUtils.getSubject(); // 获取当前主体
        UsernamePasswordToken token = new UsernamePasswordToken("test01-rick", "123456");
        // 3. test01-rick 登陆
        subject.login(token); // 登录
        // 4. subject.isAuthenticated()方法返回一个boolean值,用于判断用户是否认证成功
        System.out.println("rick::isAuthenticated:" + subject.isAuthenticated()); // 输出true
        subject.logout(); // 登出
        System.out.println("rick::isAuthenticated:" + subject.isAuthenticated()); // 输出false
        // 5. test01-tom 登陆
        UsernamePasswordToken token2 = new UsernamePasswordToken("test01-tom", "123456");
        subject.login(token2); // 登录
        System.out.println("tom::isAuthenticated:" + subject.isAuthenticated()); // 输出true
        // 判断subject是否具有admin和user两个角色权限,如没有则会报错
        subject.checkRoles("admin","test");
//        subject.checkRole("xxx"); // 报错
    }

    // 测试自己的 Realm 类
    private void test02() {
        MyRealm myRealm = new MyRealm(); // 实现自己的 Realm 实例
        // 1.构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myRealm);
        // 2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager); // 设置SecurityManager环境
        Subject subject = SecurityUtils.getSubject(); // 获取当前主体
        UsernamePasswordToken token = new UsernamePasswordToken("test02-rick", "123456");
        subject.login(token); // 登录
        // subject.isAuthenticated()方法返回一个boolean值,用于判断用户是否认证成功
        System.out.println("isAuthenticated:" + subject.isAuthenticated()); // 输出true
        // 判断subject是否具有admin和user两个角色权限,如没有则会报错
        subject.checkRoles("admin", "test");
        System.out.println("checkRoles-ok");
//        subject.checkRole("xxx"); // 报错
        // 判断subject是否具有user:add权限
        subject.checkPermission("user:add");
        System.out.println("checkPermission-ok");
    }
}
