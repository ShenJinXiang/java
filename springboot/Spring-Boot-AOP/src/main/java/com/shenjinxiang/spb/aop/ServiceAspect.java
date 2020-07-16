package com.shenjinxiang.spb.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/9 08:17
 */
@Component
@Aspect
public class ServiceAspect {

    private static final Logger log = LoggerFactory.getLogger(ServiceAspect.class);

    @Pointcut("execution(public * com.shenjinxiang.spb.service.StudentService.*(..))")
    public void studentServiceLog() {}

    @Pointcut("execution(public * com.shenjinxiang.spb.service.BookService.*(..))")
    public void bookServiceLog() {}

    @Around("studentServiceLog() || bookServiceLog()")
    public Object aroundStudentService(ProceedingJoinPoint point) {
        String className = point.getTarget().getClass().getName();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Object[] args = point.getArgs();
        log.info("请求方法：" + className + "." + signature.getName());
        log.info("请求参数：" + JSON.toJSONString(args));
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable e) {
        }
        log.info("返回结果：" + JSON.toJSONString(result));
        return result;
    }
}
