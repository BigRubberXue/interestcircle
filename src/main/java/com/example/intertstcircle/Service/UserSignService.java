package com.example.intertstcircle.Service;

import com.example.intertstcircle.User.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Slf4j
@Repository
public class UserSignService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(User user){
        jdbcTemplate.update("INSERT INTO myuser(username,password) VALUE (?,?)",user.getUsername(),user.getPassword());
        log.info("用户名："+user.getUsername()+"密码："+user.getPassword());
    }

    public int selectUsercount(User user){
        int i =jdbcTemplate.queryForObject("SELECT COUNT(*) FROM  myuser WHERE username=?",int.class,user.getUsername());
        log.info("成功查询,结果为: "+i);
        return i;
    }

    public boolean checkUserExist(User user){
        int i = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM  myuser WHERE username=? AND password=?",int.class,user.getUsername(),user.getPassword());
        log.info("成功查询,结果为:"+i);
        return (i==1);
    }


}
