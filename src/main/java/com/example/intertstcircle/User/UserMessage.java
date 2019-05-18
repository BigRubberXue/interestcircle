package com.example.intertstcircle.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
public class UserMessage {
    public Integer user_id;
    public String address;
    public String phone;
    public String mail;
    public String job;

}
