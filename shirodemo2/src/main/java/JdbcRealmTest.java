import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;



/**
 * @Author: Ping
 * @Date: Created in 11:13 2017/11/14
 */
public class JdbcRealmTest {
    public static void main(String[] args) {

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:jdbc_realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("java1234","123456");
        try {

            subject.login(usernamePasswordToken);
            System.out.println("登陆成功！");
        }catch (AuthenticationException e ){
            e.printStackTrace();
        }
        subject.logout();
    }
}
