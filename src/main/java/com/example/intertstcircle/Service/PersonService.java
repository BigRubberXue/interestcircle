package com.example.intertstcircle.Service;

import com.example.intertstcircle.User.User;
import com.example.intertstcircle.User.UserMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class PersonService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User mymessage(User myuser){
        return jdbcTemplate.queryForObject("select * from myuser where user_id=?",User.class,myuser.getUser_id());
    }

    public void UpdateMyMessage(UserMessage msg){
        jdbcTemplate.update("update person_user set address=?,phone=?,mail=?,job=? where user_id=?;",
                    msg.getAddress(),msg.getPhone(),msg.getMail(),msg.getJob(),msg.getUser_id()
                );
        log.info("update finished");
    }

    public UserMessage getUserMessage(User myuser){
        return jdbcTemplate.queryForObject("select * from person_user where user_id=?",UserMessage.class,myuser.getUser_id());
    }



}
