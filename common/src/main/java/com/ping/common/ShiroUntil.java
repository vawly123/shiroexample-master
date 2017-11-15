package com.ping.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.apache.shiro.subject.Subject;



/**
 * @Author: Ping
 * @Date: Created in 13:10 2017/11/14
 */
public class ShiroUntil {
    public static Subject login(String configFile, String username, String password){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            System.out.println("认证成功！");
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("认证失败！");
        }
        return subject;

    }
}
