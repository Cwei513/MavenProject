package com.atguigu.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author : chen wei
 * @date : 2023/5/5 19:25
 * @Version: 1.0
 * @Description :  TODO： 这是一个切面类    切面类要添加@Component注解、@Aspect注解
 */
@Component
@Aspect
public class LoggingAspect {
    /**
     * 前置通知
     * @param joinPoint
     */

    //通知框架什么时候执行
    // 切入点  "execution(* com.atguigu.service.impl.*.*(..))"
    @Before("execution(* com.atguigu.service.impl.*.*(..))")
    public void printLogBefore(JoinPoint joinPoint){
        // JoinPoint 代表目标方法，我们可以通过JoinPoint来获取目标方法的签名信息、目标类的信息、方法的参数
        //获取目标方法所在类的全限定名
        String className = joinPoint.getTarget().getClass().getName();
        //获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取目标方法的参数列表
        Object[] args = joinPoint.getArgs();
        //获取当前目标方法的信息：包含类、方法名、方法参数
        System.out.println("[前置通知]["+className+"]类的["+methodName+"]方法执行了，该方法的参数是:"+ Arrays.asList(args));

    }

    /**
     * 返回通知
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "execution(* com.atguigu.service.impl.*.*(..))",returning = "result")
    public void printLogAfterReturning(JoinPoint joinPoint,Object result){
        // JoinPoint 代表目标方法，我们可以通过JoinPoint来获取目标方法的签名信息、目标类的信息、方法的参数
        //获取目标方法所在类的全限定名
        String className = joinPoint.getTarget().getClass().getName();
        //获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取目标方法的参数列表
//        Object[] args = joinPoint.getArgs();
        //获取当前目标方法的信息：包含类、方法名、方法参数
        System.out.println("[返回通知]["+className+"]类的["+methodName+"]方法执行了，该方法的返回值是："+result);

    }

    /**
     * 异常通知
     * @param joinPoint
     * @param throwable
     */
    @AfterThrowing(value = "execution(* com.atguigu.service.impl.*.*(..))",throwing = "throwable")
    public void printLogAfterThrowing(JoinPoint joinPoint,Throwable throwable){
        // JoinPoint 代表目标方法，我们可以通过JoinPoint来获取目标方法的签名信息、目标类的信息、方法的参数
        //获取目标方法所在类的全限定名
        String className = joinPoint.getTarget().getClass().getName();
        //获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取目标方法的参数列表
//        Object[] args = joinPoint.getArgs();
        //获取当前目标方法的信息：包含类、方法名、方法参数
        System.out.println("[异常通知]["+className+"]类的["+methodName+"]方法执行异常结束了，异常信息是:"+throwable);

    }


    @After("execution(* com.atguigu.service.impl.*.*(..))")
    public void printLogAfter(JoinPoint joinPoint){
        // JoinPoint 代表目标方法，我们可以通过JoinPoint来获取目标方法的签名信息、目标类的信息、方法的参数
        //获取目标方法所在类的全限定名
        String className = joinPoint.getTarget().getClass().getName();
        //获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取目标方法的参数列表
//        Object[] args = joinPoint.getArgs();
        //获取当前目标方法的信息：包含类、方法名、方法参数
        System.out.println("[后置通知]["+className+"]类的["+methodName+"]方法执行结束了");

    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return  Object类，必须要有返回值
     */
    @Around( "execution(* com.atguigu.service.impl.*.*(..))")
    public Object printMethodInvokeTime(ProceedingJoinPoint proceedingJoinPoint){
        //获取目标方法所在类的全限定名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //获取目标方法的方法名
        String methodName = proceedingJoinPoint.getSignature().getName();

        //1. 获取目标方法执行之前的总毫秒数
        long startTime = System.currentTimeMillis();

        try {
            //2. 执行目标方法
            //这里是实际执行的目标方法，执行的结果返回给了环绕通知，环绕通知如果是无返回值（void）的话，那么执行的结果将无法返回出来，执行的目标方法外面拓了一层环绕通知
            Object proceed = proceedingJoinPoint.proceed();
            return proceed;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }finally {
            //3. 获取目标方法执行之后的总毫秒数
            long endTime = System.currentTimeMillis();
            //4. 计算执行总时长
            System.out.println("[环绕通知]["+className+"]类的["+methodName+"]方法执行的总时长为:"+(endTime - startTime));
        }

    }



}
