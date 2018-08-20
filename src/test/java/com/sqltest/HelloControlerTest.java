package com.sqltest;

import com.sqltest.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControlerTest {

    private MockMvc mvc;

    //初始化执行
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    //验证controller是否正常响应并打印返回结果
    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello")    // 调用接口
                 //传入参数类型
                //.contentType(MediaType.APPLICATION_JSON_UTF8)
                //.param("userId", "11").param("userName", "henry")//传入添加的用户参数

                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)) //接收的类型
                .andExpect(status().isOk()) //判断接收到的状态是否是200
                .andDo(MockMvcResultHandlers.print())   //打印内容
                .andReturn();
    }

    //验证controller是否正常响应并判断返回结果是否正确
    @Test
    public void testHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello")    // 调用接口
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)) //接收的类型
                .andExpect(status().isOk()) //判断接收到的状态是否是200
                .andExpect(content().string(equalTo("显示Hello")));   //匹配返回值中的内容
    }

}
