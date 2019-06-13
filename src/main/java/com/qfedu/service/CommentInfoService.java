package com.qfedu.service;

import com.qfedu.pojo.CommentInfo;

import java.util.Map;

/**
 * Created by Administrator on 2019/6/12.
 */
public interface CommentInfoService {

    public Map<String,Object> findByPage(Integer pageNum, Integer limit,Integer nid);
    public void addComment(CommentInfo commentInfo);
}
