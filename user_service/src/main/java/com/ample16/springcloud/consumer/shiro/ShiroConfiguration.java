package com.ample16.springcloud.consumer.shiro;


import com.ample16.springcloud.consumer.shiro.credentials.RetryLimitHashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    //将自己的验证方式加入容器
    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(this.retryLimitHashedCredentialsMatcher());
        return myShiroRealm;
    }

    //密码校验和登录次数限制
    @Bean
    public RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher() {
        RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher = new RetryLimitHashedCredentialsMatcher();
        retryLimitHashedCredentialsMatcher.setHashAlgorithmName("md5");
        retryLimitHashedCredentialsMatcher.setHashIterations(2);
        retryLimitHashedCredentialsMatcher.isStoredCredentialsHexEncoded();
        return retryLimitHashedCredentialsMatcher;
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new HashMap<String, String>();
        //swagger相关
        map.put("/swagger-ui.html/**", "anon");
        map.put("/v2/api-docs", "anon");
        map.put("/swagger-resources/**", "anon");
        map.put("/user/register", "anon");
        map.put("/login", "anon");
        map.put("/logout", "anon");
        //对所有用户认证,所有的url都需要经过验证器
        map.put("/**", "authc");
        //未登录的访问
        shiroFilterFactoryBean.setLoginUrl("/405");
        //登录成功后访问的页面
        //shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误页面，没有权限的时候访问，貌似没有起到作用，待研究20181221
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}