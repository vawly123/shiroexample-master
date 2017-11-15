import com.ping.common.ShiroUntil;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Ping
 * @Date: Created in 13:24 2017/11/14
 */



public class PremissionTest {
    /**
     *基于权限认证
     *    boolean boolean = isPermitted（String Permission）
     *     boolean[] boolean = isPermitted（String Permission1,String Permission2,String ....）
     *     boolean boolean = isPermittedAll(String Permission1,String Permission2,String ....)
     *
     *     CheckPermitted（String Permission）
     *     CheckPermitted（String Permission1,String Permission2,String ....）
     *     CheckPermittedAll（String Permission1,String Permission2,String ....）
     *
     * */
    @Test
    public void testHasPremission(){
        Subject subject = ShiroUntil.login("classpath:shiro-premission.ini", "lisi", "111");
        //Subject subject = ShiroUntil.login("classpath:shiro-premission.ini", "zhangsan", "123456");
        //System.out.println(subject.isPermitted("user:update")?"有这个权限":"没有这个权限");
//        boolean[] booleans = subject.isPermitted("user:select", "user:update", "user:inset");
//        for (int i = 0;i < booleans.length;i ++){
//            System.out.println(booleans[i]?"有这个权限":"没有这个权限");
//        }
        subject.checkPermission("user:select");
        subject.logout();
    }

}
