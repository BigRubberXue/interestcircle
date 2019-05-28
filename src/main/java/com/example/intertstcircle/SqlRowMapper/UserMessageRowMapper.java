package com.example.intertstcircle.SqlRowMapper;

import com.example.intertstcircle.User.UserMessage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMessageRowMapper  implements RowMapper<UserMessage> {
    @Override
    public UserMessage mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer user_id = resultSet.getInt("user_id");
        String address = resultSet.getString("address");
        String mail = resultSet.getString("mail");
        String job = resultSet.getString("job");
        String phone = resultSet.getString("phone");
        //把数据封装成User对象
        UserMessage userMessage = new UserMessage();
        userMessage.builder().user_id(user_id)
                    .address(address)
                    .mail(mail)
                    .job(job)
                    .phone(phone)
                    .build();
        return userMessage;
    }
}
