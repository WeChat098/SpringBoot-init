package com.yhzhang.springbootinit.esdao;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.yhzhang.springbootinit.model.dto.post.PostEsDTO;

/**
 * 帖子 ES 操作
 *
 * @author <a href="https://github.com/WeChat098">程序员yhzhang</a>
 * 
 */
public interface PostEsDao extends ElasticsearchRepository<PostEsDTO, Long> {

    List<PostEsDTO> findByUserId(Long userId);
}