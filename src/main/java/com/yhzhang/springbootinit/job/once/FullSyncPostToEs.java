package com.yhzhang.springbootinit.job.once;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import cn.hutool.core.collection.CollUtil;
import org.springframework.boot.CommandLineRunner;

import com.yhzhang.springbootinit.esdao.PostEsDao;
import com.yhzhang.springbootinit.model.dto.post.PostEsDTO;
import com.yhzhang.springbootinit.model.entity.Post;
import com.yhzhang.springbootinit.service.PostService;

/**
 * 全量同步帖子到 es
 *
 * @author <a href="https://github.com/WeChat098">程序员yhzhang</a>
 * 
 */
// todo 取消注释开启任务
// @Component
@Slf4j
public class FullSyncPostToEs implements CommandLineRunner {

    @Resource
    private PostService postService;

    @Resource
    private PostEsDao postEsDao;

    @Override
    public void run(String... args) {
        List<Post> postList = postService.list();
        if (CollUtil.isEmpty(postList)) {
            return;
        }
        List<PostEsDTO> postEsDTOList = postList.stream().map(PostEsDTO::objToDto).collect(Collectors.toList());
        final int pageSize = 500;
        int total = postEsDTOList.size();
        log.info("FullSyncPostToEs start, total {}", total);
        for (int i = 0; i < total; i += pageSize) {
            int end = Math.min(i + pageSize, total);
            log.info("sync from {} to {}", i, end);
            postEsDao.saveAll(postEsDTOList.subList(i, end));
        }
        log.info("FullSyncPostToEs end, total {}", total);
    }
}
