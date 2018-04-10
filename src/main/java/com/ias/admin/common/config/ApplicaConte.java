package com.ias.admin.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


//直接编码方式获取
//
@Component
public class ApplicaConte implements ApplicationContextAware{
    private static Logger logger = LoggerFactory.getLogger(ApplicaConte.class);
    private static ApplicationContext APPLICATION_CONTEXT;


    /**
     * 设置spring上下文
     * @param applicationContext spring上下文
     * @throws BeansException
     * */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.debug("ApplicationContext registed-->{}", applicationContext);
        APPLICATION_CONTEXT = applicationContext;
    }

    /**
     * 获取容器
     * @return
     */
    public static ApplicationContext getApplicationContext(){
        return APPLICATION_CONTEXT;
    }

    /**
     * 获取容器对象
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> type){
        return APPLICATION_CONTEXT.getBean(type);
    }

}
