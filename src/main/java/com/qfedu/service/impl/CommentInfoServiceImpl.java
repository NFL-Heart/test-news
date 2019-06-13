package com.qfedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.CommentInfoDao;
import com.qfedu.pojo.CommentInfo;
import com.qfedu.service.CommentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/12.
 */
@Service
public class CommentInfoServiceImpl implements CommentInfoService {

    @Autowired
    private CommentInfoDao commentInfoDao;
    @Override
    public Map<String, Object> findByPage(Integer pageNum, Integer limit,Integer nid) {
        PageHelper.startPage(pageNum, limit);
        List<CommentInfo> list = commentInfoDao.findAll(nid);

        Map<String, Object> map = new HashMap<>();
        map.put("totalPage", ((Page)list).getPages());// 总页数
        map.put("count", ((Page)list).getTotal());// 总记录数
        map.put("currentPage", pageNum);
        map.put("list", list);

        return map;
    }
    @Override
    public void addComment(CommentInfo commentInfo) {
        commentInfoDao.add(commentInfo);
    }
}
