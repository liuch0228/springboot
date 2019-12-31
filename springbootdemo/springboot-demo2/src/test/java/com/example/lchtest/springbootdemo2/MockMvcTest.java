package com.example.lchtest.springbootdemo2;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

/**
 * springboot测试 @SpringBootTest注解后面要加上主启动类，否则会报错
 * MockMvc: 模拟接口请求
 * (1) 加上@AutoConfigureMockMvc注解
 * (2) perform : 执行一个RequestBuilder请求
 *     andExpect: 添加ResultMatcher-> MockMvcResultMatchers验证规则
 *     andReturn 返回相应的MvcResult
 */
@AutoConfigureMockMvc
@SpringBootTest(classes={App.class})
public class MockMvcTest {

    /**
     * mockMvc等同于一个http客户端
     */
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void  apiTest() throws Exception {
        MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders.get("/test/getName"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);
    }


}
