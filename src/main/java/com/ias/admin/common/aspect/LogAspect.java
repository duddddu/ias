package com.ias.admin.common.aspect;

import com.ias.admin.common.annotation.Log;
import com.ias.admin.common.util.ShiroUtils;
import com.ias.admin.system.mapper.LogMapper;
import com.ias.admin.system.pojo.AdminPO;
import com.ias.admin.system.pojo.LogPO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {
    @Autowired
    LogMapper logMapper;

    @Pointcut("@annotation(com.ias.admin.common.annotation.Log)")
    public void logPointCut(){

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长
        long time = System.currentTimeMillis() - beginTime;
        //异步保存日志
        saveLog(point/*, time*/);

        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint/*, long time*/){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogPO log = new LogPO();
        Log log1 = method.getAnnotation(Log.class);
        if (log != null){
            // 注解上的描述
            log.setOperation(log1.value());
        }
        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.setFunctions(className + "." + methodName + "()");

        StringBuilder content = new StringBuilder();

        AdminPO admin = ShiroUtils.getAdmin();
        if(admin == null){
            log.setOperatorId(-1);
            content.append("用户 undefined");

        }else{
            log.setOperatorId(admin.getId());
            content.append("管理员 " + admin.getName());
        }
        /*content.append()

        //请求的参数
        Object[] args = joinPoint.getArgs();
        try{
            String params = JSONUtils.
        }*/
        log.setOperationTime(new Date());
        //保存系统日志
        logMapper.save(log);
    }
}
