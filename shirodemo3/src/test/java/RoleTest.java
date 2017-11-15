import org.apache.shiro.subject.Subject;
import org.junit.Test;
import com.ping.common.ShiroUntil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Ping
 * @Date: Created in 13:24 2017/11/14
 */



public class RoleTest {
    /**
     *基于角色认证
     *     boolean boolean = hasRole（String Permission）
     *     boolean[] boolean = hasRoles（String Permission1,String Permission2,String ....）
     *     boolean boolean = hasAllRoles(Collection<> list)
     *
     *     checkRole（String Permission）
     *     checkRoles（String Permission1,String Permission2,String ....）
     *     checkRoles（Collection<> list）
     * */
    @Test
    public void testHasRole(){
        Subject subject = ShiroUntil.login("classpath:shiro-role.ini", "lisi", "111");
        //System.out.println(subject.hasRole("role1")?"有这个角色":"没有这个角色");
        boolean[] roles = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));
        for (int i = 0;i < roles.length;i ++) {
            System.out.println(roles[i] ? "有这个角色" : "没有这个角色");
        }
        subject.logout();
    }

}
