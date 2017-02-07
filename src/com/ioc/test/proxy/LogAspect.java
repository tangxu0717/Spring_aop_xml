package com.ioc.test.proxy;

import com.ioc.test.log.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by tangxu on 2017/1/14.
 */
@Component("logAspect")//让这个切面类被Spring所管理
public class LogAspect {
    public void logStart(JoinPoint jp){
        //得到执行的对象
        System.out.println(jp.getTarget());
        //提到执行的方法
        System.out.println(jp.getSignature().getName());
        Logger.info("加入日志");
    }

    public void logEnd(JoinPoint jp){
        Logger.info("方法调用结束加入日志");
    }

    public void logAround(ProceedingJoinPoint pjp){
        Logger.info("开始在Around中加入日志");
        try {
            pjp.proceed();//执行程序
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Logger.info("结束Around");
    }
}
