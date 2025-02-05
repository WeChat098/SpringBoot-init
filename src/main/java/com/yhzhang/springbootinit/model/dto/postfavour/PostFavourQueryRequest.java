package com.yhzhang.springbootinit.model.dto.postfavour;

import java.io.Serializable;

import com.yhzhang.springbootinit.common.PageRequest;
import com.yhzhang.springbootinit.model.dto.post.PostQueryRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 帖子收藏查询请求
 *
 * @author <a href="https://github.com/WeChat098">程序员yhzhang</a>
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PostFavourQueryRequest extends PageRequest implements Serializable {

    /**
     * 帖子查询请求
     */
    private PostQueryRequest postQueryRequest;

    /**
     * 用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}