package com.qfedu.service;

import com.qfedu.pojo.CommentInfo;

import java.util.Map;

/**
 * Created by Administrator on 2019/6/12.
 */
public interface NewsService {

    public Map<String,Object> findByPage(Integer pageNum, Integer limit);

    public Map<String,Object> findByCondition(Integer pageNum, Integer limit, String keyword);


    public void delete(Integer nid);
}
