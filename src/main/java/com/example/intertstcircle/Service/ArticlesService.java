package com.example.intertstcircle.Service;

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

}
