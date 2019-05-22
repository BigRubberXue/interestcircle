package com.example.intertstcircle.Service;

import com.example.intertstcircle.User.ArticleMessage;
import com.example.intertstcircle.User.Articles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class ArticlesService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Articles> getAllarticles(){
        List<Articles> s = new ArrayList<Articles>();
        s=jdbcTemplate.query("select * from article",new BeanPropertyRowMapper(Articles.class));
        log.info("返回成功，s的长度为： " +s.size());
        return s;
    }

    public Articles getArticle(int articleId){
        Articles article = new Articles();
        article=jdbcTemplate.queryForObject("select * from article where articleId=?",Articles.class);
        log.info("查找完成");
        return article;
    }



    public int getArticleId(String ArticleTitle){
        //get article_id by ArticleTitle
        return jdbcTemplate.queryForObject("select article_id from article where article_title = ?",Integer.class,ArticleTitle);
    }

    public int getArticleUserId(String ArticleTitle){
        //get Article UserId by ArticleTitle
        return jdbcTemplate.queryForObject("select user_id from article where article_title = ?",Integer.class,ArticleTitle);
    }

    public int getArticleUserId(Integer ArticleId){
        //get Article by ArticleId
        return jdbcTemplate.queryForObject("select user_id from article where article_id = ?",Integer.class,ArticleId);
    }

    public void updateReward(Integer UserId,Integer ArticleId,Integer preReward,String UserName){
        //update Article reward
        jdbcTemplate.update("update article set reward=? where article_id=?",preReward+1,ArticleId);
        log.info("更新完成");
        jdbcTemplate.update("insert into new(user_id,already,new) value(?,?,?)",UserId,ArticleId,UserName+
                "Reward your article : "+getArticle(ArticleId).getArticle_title());
        log.info("已将消息插入New");

    }

    public void updateThumbsup(Integer UserId,Integer ArticleId,String UserName){
        //update Thumbsup(table)
        jdbcTemplate.update("insert into thumbsup(user_id,article_id) value(?,?)",UserId,ArticleId);
        log.info("更新完成");
        jdbcTemplate.update("insert into new(user_id,already,new) value(?,?,?)",UserId,ArticleId,UserName+
                "Thumbsup your article : "+getArticle(ArticleId).getArticle_title());
        log.info("已将消息插入New");

    }

    public void updateCollect(Integer UserId,Integer ArticleId,String UserName){
        //update Collect(table)
        jdbcTemplate.update("insert into collect(user_id,article_id) value(?,?)",UserId,ArticleId);
        log.info("更新完成");
        jdbcTemplate.update("insert into new(user_id,already,new) value(?,?,?)",UserId,ArticleId,UserName+
                "collect your article : "+getArticle(ArticleId).getArticle_title());
        log.info("已将消息插入New");
    }

    public void updateAttention(Integer UserId,Integer ArticleUserId){
        //update Attention(table)
        jdbcTemplate.update("insert into attention(p_user_id,a_user_id) value(?,?)",UserId,ArticleUserId);
        log.info("更新完成");
    }

    public List<ArticleMessage> getArticleMessage(Integer ArticleId){
        return jdbcTemplate.query("select * from message where article_id = ?",new BeanPropertyRowMapper(ArticleMessage.class),ArticleId);
    }










}
