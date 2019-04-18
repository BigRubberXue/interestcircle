package com.example.intertstcircle;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;


@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer user_id;
    private String username;
    private String password;
    private String name;
    private Integer attention;
    private Integer gift;
}
