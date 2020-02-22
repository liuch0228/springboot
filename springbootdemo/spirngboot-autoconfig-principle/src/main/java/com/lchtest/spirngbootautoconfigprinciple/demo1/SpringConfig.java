package com.lchtest.spirngbootautoconfigprinciple.demo1;

import com.lchtest.spirngbootautoconfigprinciple.demo02.OtherConfig;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 声明一个配置类
 * 通过JavaConfig形式完全取代Spring xml形式来提供bean的注入
 * 这个配置类等价于Spring xml配置中的
 * <bean id="helloService" class="com.lchtest.spirngbootautoconfigprinciple.demo1.HelloService"></bean>
 * @Component注解是通过@ComponentScan注解来生效的
 */
@Configuration
// @Import() 注解导入另外一个配置类，相当于两个配置类合并 ，跟spring相比，等价于xml配置中的<import></import>标签！
@Import(value= OtherConfig.class)
public class SpringConfig {

    // @Conditional条件判断，注入HelloService的条件
    // 如果 DefineConditional类中返回的是true,才注入helloService 这个bean,否则不注入
    @Conditional(DefineConditional.class)
    @Bean
//    @Scope(value = "singleton")  // 默认是单例
    public HelloService helloService(){
        return new HelloService();
    }
}
