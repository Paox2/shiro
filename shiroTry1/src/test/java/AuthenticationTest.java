import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("username", "password", "admin", "user");
    }

    @Test
    public void testAuthentication() {
        // build environment
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // authentication request
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("username", "password");
        subject.login(token);

        System.out.println("authenticated: " + subject.isAuthenticated());

        subject.checkRoles("admin", "user");
//        subject.checkRoles("admin", "client"); // error


        subject.logout();

        System.out.println("authenticated: " + subject.isAuthenticated());
    }
}
