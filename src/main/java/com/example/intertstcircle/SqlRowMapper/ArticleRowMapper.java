package com.example.intertstcircle.SqlRowMapper;

import com.example.intertstcircle.User.Articles;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Articles> {
    @Override
    public Articles mapRow(ResultSet resultSet, int i) throws SQLException {
        String article_title=resultSet.getString("article_title");
        String articleM=resultSet.getString("article");
        Integer user_id=resultSet.getInt("user_id");
        Integer reward=resultSet.getInt("reward");
        Integer article_id=resultSet.getInt("article_id");
        Articles article = new Articles();
        article.setArticle_title(article_title);
        article.setArticle(articleM);
        article.setArticle_id(article_id);
        article.setReward(reward);
        article.setUser_id(user_id);
        return article;
    }
}
