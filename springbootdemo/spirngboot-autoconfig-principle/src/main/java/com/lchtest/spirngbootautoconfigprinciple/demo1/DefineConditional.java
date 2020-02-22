package com.lchtest.spirngbootautoconfigprinciple.demo1;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自定义条件注解
 */
public class DefineConditional implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 返回true, bean会注入，返回false，bean不会注入
        return false;
    }
}
