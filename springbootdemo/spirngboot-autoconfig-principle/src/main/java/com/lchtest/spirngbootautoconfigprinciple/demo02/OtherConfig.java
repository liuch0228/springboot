package com.lchtest.spirngbootautoconfigprinciple.demo02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfig {
    @Bean
    public OtherClass otherClass(){
        return new OtherClass();
    }
}
