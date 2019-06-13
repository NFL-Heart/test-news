package com.qfedu.controller;

import com.qfedu.pojo.CommentInfo;
import com.qfedu.pojo.News;
import com.qfedu.service.CommentInfoService;
import com.qfedu.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2019/6/12.
 */
@RestController
@RequestMapping("/comment")
public class CommentInfoController {

    @Autowired(required = false)
    private CommentInfoService commentInfoService;

    @RequestMapping("/list.do")
    public JsonBean findByPage(Integer page, Integer limit, Integer nid){
        System.out.println("11111你是傻逼"+nid);
        Map<String, Object> map = commentInfoService.findByPage(page, limit, nid);
        return new JsonBean(1,map);
    }
    @RequestMapping("/add.do")
    public JsonBean addComment(CommentInfo commentInfo,Integer nid){
        commentInfo.setNid(nid);
        commentInfoService.addComment(commentInfo);
        return new JsonBean(1,null);
    }
}
