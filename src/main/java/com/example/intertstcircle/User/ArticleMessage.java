package com.example.intertstcircle.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
public class ArticleMessage {
    private Integer un_id;
    private Integer user_id;
    private Integer article_id;
    private String message;
}
