import org.apache.commons.collections.Factory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

import java.util.List;
import java.util.ArrayList;

public class ShiroTest {
    public static void main(String[] args) {
        // User 1 and 2 to test shiro can recognize exist account, 3 to test fake user
        User user1 = new User();
        user1.setName("user1");
        user1.setPassword("pwd1");

        User user2 = new User();
        user2.setName("user2");
        user2.setPassword("pwd2");

        User user3 = new User();
        user3.setName("user3");
        user3.setPassword("pwd3");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        String roleAdmin = "admin";
        String roleUser = "user";
        List<String> roles = new ArrayList<>();
        roles.add(roleAdmin);
        roles.add(roleUser);

        String permitFindAllUser = "findAllUser";
        String permitFindUserById = "findUserById";
        List<String> permits = new ArrayList<>();
        permits.add(permitFindAllUser);
        permits.add(permitFindUserById);

        for (User user : users) {
            if (login(user)) {
                System.out.println(user.getName() + " login successful, password " + user.getPassword());
            } else {
                System.out.println(user.getName() + " fail to login, password " + user.getPassword());
            }
        }

        System.out.println("\n\n\n");

        for (User user : users) {
            for (String role : roles) {
                if(login(user)) {
                    if(hasRole(role))
                        System.out.println(user.getName() + " is " + role);
                    else
                        System.out.println(user.getName() + " is not " + role);
                }
            }
        }
        System.out.println("\n\n\n");

        for (User user : users) {
            for (String permit : permits) {
                if(login(user)) {
                    if(isPermitted(permit))
                        System.out.println(user.getName() + " can " + permit);
                    else
                        System.out.println(user.getName() + " cannot " + permit);
                }
            }
        }
    }

    private static Subject getSubject() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        defaultSecurityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        return subject;
    }


    private static boolean hasRole(String role) {
        Subject subject = getSubject();
        return subject.hasRole(role);
    }

    private static boolean isPermitted(String permit) {
        Subject subject = getSubject();
        return subject.isPermitted(permit);
    }

    private static boolean login(User user) {
        Subject subject = getSubject();
        if (subject.isAuthenticated())
            subject.logout();

        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return false;
        }
        return subject.isAuthenticated();
    }
}
