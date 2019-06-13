package com.qfedu.controller;

import com.qfedu.pojo.CommentInfo;
import com.qfedu.pojo.News;
import com.qfedu.service.NewsService;
import com.qfedu.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2019/6/12.
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/list.do")
    public JsonBean findByPage(Integer page, Integer limit, String keyword){
        Map<String,Object> map = null;
        if(keyword !=null && !keyword.equals("")){
            map = newsService.findByCondition(page, limit, keyword);
        }else{
            map = newsService.findByPage(page, limit);
        }
        return new JsonBean(1, map);
    }



    @RequestMapping("/delete.do")
    public JsonBean delete(Integer nid){
        newsService.delete(nid);
        return new JsonBean(1,null);
    }
}
