import com.test.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;


public class AuthenticationTest {
    @Test
    public void testAuthentication() {
        MyRealm myRealm = new MyRealm();
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("username", "password");
        subject.login(token);

        System.out.println(subject.isAuthenticated());

        subject.checkRoles("admin", "user");
        subject.checkPermission("findAllUser");
    }
}
