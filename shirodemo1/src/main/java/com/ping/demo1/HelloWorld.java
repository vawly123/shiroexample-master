package com.ping.demo1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import sun.applet.Main;

/**
 * @Author: Ping
 * @Date: Created in 10:51 2017/11/14
 */
public class HelloWorld {
    public static void main(String[] args) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("ping","12345");
        try {

            subject.login(usernamePasswordToken);
            System.out.println("登陆成功！");
        }catch (AuthenticationException e ){
            e.printStackTrace();
        }
        subject.logout();
    }
}
