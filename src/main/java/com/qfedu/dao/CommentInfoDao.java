package com.qfedu.dao;

import com.qfedu.pojo.CommentInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/6/12.
 */
public interface CommentInfoDao {

   public List<CommentInfo> findAll(Integer nid);
   public void add(CommentInfo commentInfo);
}
