package com.example.intertstcircle.SqlRowMapper;

import com.example.intertstcircle.User.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer user_id=resultSet.getInt("user_id");
        String username = resultSet.getString("username");
        String password=resultSet.getString("password");
        String name=resultSet.getString("name");
        Integer attention=resultSet.getInt("attention");
        Integer gift=resultSet.getInt("gift");
        User user = new User();
        user.builder()
                .user_id(user_id)
                .username(username)
                .password(password)
                .name(name)
                .attention(attention)
                .gift(gift)
                .build();
        return user;
    }
}
