package com.example.intertstcircle.Controller;

import com.example.intertstcircle.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/index")
public class PageController {


    public User user;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){

//      model.addAttribute();
        return "";
    }







}
