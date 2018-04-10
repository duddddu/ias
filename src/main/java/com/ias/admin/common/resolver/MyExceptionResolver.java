/*


package com.ias.admin.common.resolver;

import com.ias.admin.common.util.DU;
import com.ias.admin.common.util.MyLogger;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

*/
/**
 * 异常处理器
 * 全局异常包括 三种情况
 *//*


@RestControllerAdvice
public class MyExceptionResolver {
    private MyLogger logger = MyLogger.getLogger(getClass());


*/
/**
     * 自定义异常
     *//*


    @ExceptionHandler(MyException.class)
    public DU handleMyException(MyException e){
        DU du = new DU();
        du.put("code", e.getCode());
        du.put("msg", e.getMessage());

        return du;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public DU handleDuplicateKeyException(DuplicateKeyException e){
        logger.error(e.getMessage(), e);
        return DU.error("数据库种已存在该记录");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public DU noHandlerFoundException(org.springframework.web.servlet.NoHandlerFoundException e) {
        logger.error(e.getMessage(), e);
        return DU.error("没找找到页面");
    }

    @ExceptionHandler(AuthorizationException.class)
    public DU handleAuthorizationException(AuthorizationException e) {
        logger.error(e.getMessage(), e);
        return DU.error("未授权");
    }

    @ExceptionHandler(Exception.class)
    public DU handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return DU.error("服务器错误，请联系管理员");
    }

}


*/
