package com.yhzhang.springbootinit.mapper;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yhzhang.springbootinit.mapper.PostMapper;
import com.yhzhang.springbootinit.model.entity.Post;

/**
 * 帖子数据库操作测试
 *
 * @author <a href="https://github.com/WeChat098">程序员yhzhang</a>
 * 
 */
@SpringBootTest
class PostMapperTest {

    @Resource
    private PostMapper postMapper;

    @Test
    void listPostWithDelete() {
        List<Post> postList = postMapper.listPostWithDelete(new Date());
        Assertions.assertNotNull(postList);
    }
}