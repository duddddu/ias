package com.ias.admin.common.util;

import org.apache.log4j.Logger;
public class MyLogger {
    private Logger logger;

    /*
    * 构造方法， 初始化Log4j的日志对象
    * */
    private MyLogger(Logger logger) {
        this.logger = logger;
    }

    /*
    * 获取构造器， 根绝类初始化Logger对象
    *
    * @param Class Class对象
    * @return Logger对象
    * */
    public static MyLogger getLogger(Class classObject) {
        return new MyLogger(Logger.getLogger(classObject));
    }

    /**
     * 获取构造器，根据类名初始化Logger对象
     *
     * @param String 类名字字符串
     * @return Logger对象
     */
    public static MyLogger getLogger(String loggerName) {
        return new MyLogger(Logger.getLogger(loggerName));
    }

    public void debug(Object object) {
        logger.debug(object);
    }

    public void info(Object object) {
        logger.info(object);
    }

    public void info(Object object, Throwable e) {
        logger.info(object, e);
    }

    public void warn(Object object) {
        logger.warn(object);
    }

    public void warn(Object object, Throwable e) {
        logger.warn(object, e);
    }


    public void error(Object object) {
        logger.error(object);
    }

    public void error(Object object, Throwable e) {
        logger.error(object, e);
    }

    public void fatal(Object object){
        logger.fatal(object);
    }

    public String getName(){
        return logger.getName();
    }

    public Logger getLog4jLogger(){
        return logger;
    }

    public boolean equals(MyLogger newMyLogger){
        return logger.equals(newMyLogger);
    }
}
