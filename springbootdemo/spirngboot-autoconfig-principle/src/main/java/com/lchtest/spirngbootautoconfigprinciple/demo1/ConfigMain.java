package com.lchtest.spirngbootautoconfigprinciple.demo1;


import com.lchtest.spirngbootautoconfigprinciple.demo02.OtherClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigMain {

    public static void main(String[] args) {
        // AnnotationConfigApplicationContext这个类会解析JavaConfig类中的所有注解，将其注册到IOC容器中
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 从IOC容器中获取对象
        HelloService helloService = context.getBean(HelloService.class);
        System.out.println(helloService.say());
        // 直接这样获取是娶不到的，context默认扫描的是SpringConfig这个配置类,会报错
        /*Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.lchtest.spirngbootautoconfigprinciple.demo02.OtherClass' available
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:351)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:342)
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1126)
	at com.lchtest.spirngbootautoconfigprinciple.demo1.ConfigMain.main(ConfigMain.java:16)*/

//     SpringConfig类加上注解@Import(value= OtherConfig.class)后，就可以了 ，输出 com.lchtest.spirngbootautoconfigprinciple.demo02.OtherClass@48fa0f47
        OtherClass otherClass = context.getBean(OtherClass.class);
        System.out.println(otherClass);
    }
}
