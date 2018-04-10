package com.ias.admin.common.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.ias.admin.common.redis.shiro.RedisCacheManager;
import com.ias.admin.common.redis.shiro.RedisManager;
import com.ias.admin.common.redis.shiro.RedisSessionDAO;
import com.ias.admin.system.shiro.AdminRealm;
import com.ias.admin.system.shiro.CounselorRealm;
import com.ias.admin.system.shiro.StudentRealm;
import com.ias.admin.system.shiro.TeacherRealm;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.mgt.SecurityManager;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author dududu
 * @email 345912664@qq.com
 * @date 2018-04-02
 */
@Configuration
public class ShiroConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${cacheType}")
    private String cacheType;

    /**
     * <bean id="lifecycleBeanPostProcessor"
     * class="org.apache.shiro.spring.LifecycleBeanPostProcessor" />
     * </beans>
     * 将Initializable和Destroyable的实现类统一在其内部自动分别调用了Initializable.init()
     * 和Destroyable.destroy()方法，从而达到管理shiro bean生命周期的目的
     * */
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * ShiroDialect, 为了在thymeleaf里使用shiro的标签
     * */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

    /**
     * shiro的web过滤器
     * */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        //多项目再改
        shiroFilterFactoryBean.setLoginUrl("/admin/login");
        shiroFilterFactoryBean.setSuccessUrl("/admin/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put("/common/**", "anon");
        filterChainDefinitionMap.put("/admin/**", "anon");
        filterChainDefinitionMap.put("/counselorMobile/**", "anon");
        filterChainDefinitionMap.put("/studentMobile/**", "anon");
        filterChainDefinitionMap.put("/teacherMobile/**", "anon");
        filterChainDefinitionMap.put("/teacherPC/**", "anon");

        filterChainDefinitionMap.put("/**", "anon");
        filterChainDefinitionMap.put("/", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 安全管理器
     * */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm
        // 使用多个realm
        //securityManager.setRealm(adminRealm());
        securityManager.setAuthenticator(authenticator());

        // 自定义缓存实现 使用redis
        if(Const.CACHE_TYPE_REDIS == cacheType){
            securityManager.setCacheManager(cacheManager());
        }else{
            securityManager.setCacheManager(ehCacheManager());
        }
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * Realm实现
     * 使用多个realm，所以注释单个
     */
    /*@Bean
    public AdminRealm adminRealm(){
        return new AdminRealm();
    }*/

    @Bean
    public ModularRealmAuthenticator authenticator(){
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        authenticator.setRealms(realms());
        return authenticator;
    }

    @Bean
    public Collection<Realm> realms(){
        List<Realm> realmList = new ArrayList<>();
        realmList.add(new StudentRealm());
        realmList.add(new AdminRealm());
        realmList.add(new TeacherRealm());
        realmList.add(new CounselorRealm());
        return realmList;
    }
    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }



    //以下是shiro和redis的配置
    /**
     * 配置shiro redisManager
     * @return
     */
    @Bean
    public RedisManager redisManager(){
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setExpire(1800);// 配置缓存过期时间
        //redisManager.setTimeout(1800);
        redisManager.setPassword(password);
        return redisManager;
    }

    /**
     * cacheManager 缓存 redis实现
     * 使用的是shiro-redis开源插件
     * @return
     */
    public RedisCacheManager cacheManager(){
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }


    //以下是shiro和session的配置
    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public RedisSessionDAO redisSessionDAO(){
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    @Bean
    public SessionDAO sessionDAO(){
        if(Const.CACHE_TYPE_REDIS.equals(cacheType)){
            return redisSessionDAO();
        }
        else{
            return new MemorySessionDAO();
        }
    }


    //将session托管给redis进行管理，便于搭建集群系统
    /**
     * shiro session的管理
     */
    @Bean
    public DefaultWebSessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(sessionDAO());
        Collection<SessionListener> listeners = new ArrayList<>();
        listeners.add(new BDSessionListener());
        sessionManager.setSessionListeners(listeners);
        return sessionManager;
    }

    /*
    * 缓存管理器 默认使用Ehcache
    * */
    @Bean
    public EhCacheManager ehCacheManager(){
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:config/ehcache.xml");
        return em;
    }
}
