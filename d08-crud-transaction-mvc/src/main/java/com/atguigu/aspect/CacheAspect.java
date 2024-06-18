package com.atguigu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 包名:com.atguigu.aspect
 *
 * @author Leevi
 * 日期2023-05-06  11:45
 */
//@Component
@Aspect
@Order(1)
public class CacheAspect {
    private Map<String,Object> cache = new HashMap<>();
    /**
     * 从缓存中获取数据
     * @return
     */
    @Around("com.atguigu.aspect.AtguiguPointcut.cachePt()")
    public Object getCachedData(ProceedingJoinPoint proceedingJoinPoint){
        //1. 从缓存中获取数据
        //1.1 指定缓存的key: 类的全限定名 + 方法名 + 参数
        String key = proceedingJoinPoint.getTarget().getClass().getName() + ":" + proceedingJoinPoint.getSignature().getName();
        //判断是否有参数
        if (proceedingJoinPoint.getArgs() != null && proceedingJoinPoint.getArgs().length > 0) {
            //有参数
            key += ":" + Arrays.asList(proceedingJoinPoint.getArgs());
        }
        //1.2 根据key从缓存中获取数据
        Object result = cache.get(key);
        //2. 判断缓存中是否有数据
        if (result == null) {
            //2.1 如果缓存中没有数据，调用核心方法从数据库中查询
            try {
                result = proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            //2.2 将数据存入缓存
            cache.put(key,result);
        }
        return result;
    }
}
