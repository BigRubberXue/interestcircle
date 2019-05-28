package com.example.intertstcircle.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Articles {
    private String article_title;
    private String article;
    private Integer user_id;
    private Integer reward;
    private Integer article_id;
}
