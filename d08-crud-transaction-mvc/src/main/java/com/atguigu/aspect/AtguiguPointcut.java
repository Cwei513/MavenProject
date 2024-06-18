package com.atguigu.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 包名:com.atguigu.aspect
 *
 * @author Leevi
 * 日期2023-05-06  08:55
 */
public class AtguiguPointcut {
    @Pointcut("execution(* com.atguigu.service.impl.*.*(..))")
    public void pt1(){}

    @Pointcut("@annotation(AtguiguCache)")
    public void cachePt(){}
}
