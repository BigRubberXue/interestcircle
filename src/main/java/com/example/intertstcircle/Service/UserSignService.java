package com.example.intertstcircle.Service;

import com.example.intertstcircle.SqlRowMapper.UserRowMapper;
import com.example.intertstcircle.User.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Slf4j
@Repository
public class UserSignService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(User user){
        jdbcTemplate.update("INSERT INTO myuser(username,password,name) VALUE (?,?,?)",user.getUsername(),user.getPassword(),user.getName());
        log.info("用户名："+user.getUsername()+"密码："+user.getPassword());
        jdbcTemplate.update("INSERT INTO person_user(user_id,address,phone,mail,job) VALUE (?,null,null,null,null)"
                    ,getUserIdByUsername(user.getUsername())
        );
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

    public int getUserIdByUsername(String username){
        return jdbcTemplate.queryForObject("select user_id from myuser where username=?",Integer.class,username);
    }

    public User getUserByUsername(String uname){
        String s = "select * from myuser where user_id="+getUserIdByUsername(uname);
        return jdbcTemplate.queryForObject(s,new UserRowMapper());
    }

    public String getNameByUserId(Integer userId){
        String s = "select name from myuser where user_id="+userId;
        System.out.println(s);
        return jdbcTemplate.queryForObject(s,String.class);
    }


}
