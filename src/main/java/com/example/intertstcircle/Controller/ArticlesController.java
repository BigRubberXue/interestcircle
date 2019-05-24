package com.example.intertstcircle.Controller;

import com.example.intertstcircle.Service.ArticlesService;
import com.example.intertstcircle.Service.UserSignService;
import com.example.intertstcircle.User.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/article")
public class ArticlesController {

    @Autowired
    ArticlesService articlesService;

    @Autowired
    UserSignService userSignService;


    @RequestMapping(value="/{AtricleId}", method = RequestMethod.GET)
    public String articleShow(Model model,@PathVariable Integer AtricleId){
        Articles article=articlesService.getArticle(AtricleId);
        model.addAttribute("article",article);
        model.addAttribute("authorName",userSignService.getNameByUserId(article.getUser_id()));
        return "articleShow";
    }

}
