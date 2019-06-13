package com.qfedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.NewsDao;
import com.qfedu.pojo.CommentInfo;
import com.qfedu.pojo.News;
import com.qfedu.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/12.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;
    @Override
    public Map<String, Object> findByPage(Integer pageNum, Integer limit) {

        PageHelper.startPage(pageNum, limit);
        List<News> list = newsDao.findAll();

        Map<String, Object> map = new HashMap<>();
        map.put("totalPage", ((Page)list).getPages());// 总页数
        map.put("count", ((Page)list).getTotal());// 总记录数
        map.put("currentPage", pageNum);
        map.put("list", list);

        return map;
    }

    @Override
    public Map<String, Object> findByCondition(Integer pageNum, Integer limit, String keyword) {
        PageHelper.startPage(pageNum, limit);
        List<News> list = newsDao.findByKeyword(keyword);

        Map<String, Object> map = new HashMap<>();
        map.put("totalPage", ((Page)list).getPages());// 总页数
        map.put("count", ((Page)list).getTotal());// 总记录数
        map.put("currentPage", pageNum);
        map.put("list", list);

        return map;
    }



    @Override
    public void delete(Integer nid) {
        newsDao.delete(nid);
    }
}
