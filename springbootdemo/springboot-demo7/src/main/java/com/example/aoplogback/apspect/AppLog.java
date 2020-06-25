package com.example.aoplogback.apspect;

import java.lang.annotation.*;

/**
 * 自定义注解
 */
//注解放置的目标位置,METHOD是可注解在方法级别上
@Target(ElementType.METHOD)
// 注解在哪个阶段生效
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AppLog {

    // 日志内容
    String value() default "";
}
