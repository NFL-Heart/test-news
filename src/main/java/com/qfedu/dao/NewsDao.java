package com.qfedu.dao;

import com.qfedu.pojo.CommentInfo;
import com.qfedu.pojo.News;

import java.util.List;

/**
 * Created by Administrator on 2019/6/12.
 */
public interface NewsDao {

    public List<News> findAll();

    public List<News> findByKeyword(String keyword);


    public void delete(Integer nid);
}
