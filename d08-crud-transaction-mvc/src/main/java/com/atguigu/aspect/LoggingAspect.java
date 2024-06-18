package com.atguigu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 包名:com.atguigu.aspect
 *
 * @author Leevi
 * 日期2023-05-05  11:35
 */
@Component
@Aspect
@Order(2)
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @Before("com.atguigu.aspect.AtguiguPointcut.pt1()")
    public void printLogBefore(JoinPoint joinPoint){
        //获取目标方法所在类的全限定名
        String className = joinPoint.getTarget().getClass().getName();
        //获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取目标方法的参数列表
        Object[] args = joinPoint.getArgs();
        //获取当前目标方法的信息:包含类、方法名、方法参数
        logger.info("[前置通知][{}]类的[{}]方法执行了，该方法的参数是{}",className,methodName, Arrays.asList(args));
    }

    @AfterReturning(value = "com.atguigu.aspect.AtguiguPointcut.pt1()",returning = "result")
    public void printLogAfterReturning(JoinPoint joinPoint,Object result){
        //获取目标方法所在类的全限定名
        String className = joinPoint.getTarget().getClass().getName();
        //获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取目标方法的返回值
        //获取当前目标方法的信息:包含类、方法名、方法参数
        logger.info("[返回通知][{}]类的[{}]方法执行正常结束了，方法的返回值是:{}",className,methodName,result);
    }

    @AfterThrowing(value = "com.atguigu.aspect.AtguiguPointcut.pt1()",throwing = "throwable")
    public void printLogAfterThrowing(JoinPoint joinPoint,Throwable throwable){
        //获取目标方法所在类的全限定名
        String className = joinPoint.getTarget().getClass().getName();
        //获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取目标方法的返回值
        //获取当前目标方法的信息:包含类、方法名、方法参数
        logger.info("[异常通知][{}]类的[{}]方法执行异常结束了，异常信息是:{}",className,methodName,throwable);
    }

    @After(value = "com.atguigu.aspect.AtguiguPointcut.pt1()")
    public void printLogAfter(JoinPoint joinPoint){
        //获取目标方法所在类的全限定名
        String className = joinPoint.getTarget().getClass().getName();
        //获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取目标方法的返回值
        //获取当前目标方法的信息:包含类、方法名、方法参数
        logger.info("[后置通知][{}]类的[{}]方法执行结束了",className,methodName);
    }

    @Around(value = "com.atguigu.aspect.AtguiguPointcut.pt1()")
    public Object printMethodInvokeTime(ProceedingJoinPoint proceedingJoinPoint){
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        //1. 获取目标方法执行之前的总毫秒数
        long startTime = System.currentTimeMillis();
        try {
            //2. 执行目标方法
            Object result = proceedingJoinPoint.proceed();
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }finally {
            //3. 获取目标方法执行之后的总毫秒数
            long endTime = System.currentTimeMillis();
            //4. 计算执行总时长
            logger.info("[环绕通知][{}]类的[{}]方法执行的总时长为:{}",className,methodName,(endTime - startTime));
        }
    }
}
