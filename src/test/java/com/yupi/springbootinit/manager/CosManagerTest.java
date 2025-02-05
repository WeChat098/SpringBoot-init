package com.yhzhang.springbootinit.manager;

import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yhzhang.springbootinit.manager.CosManager;

/**
 * Cos 操作测试
 *
 * @author <a href="https://github.com/WeChat098">程序员yhzhang</a>
 * 
 */
@SpringBootTest
class CosManagerTest {

    @Resource
    private CosManager cosManager;

    @Test
    void putObject() {
        cosManager.putObject("test", "test.json");
    }
}