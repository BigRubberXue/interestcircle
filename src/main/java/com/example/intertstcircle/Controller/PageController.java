package com.example.intertstcircle.Controller;

import com.example.intertstcircle.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/index")
public class PageController {

    @Autowired
    public User user;

    @ModelAttribute
    public void init(HttpSession session){
        user=(User)session.getAttribute("User");
        if(user==null) {
            System.out.println("null");
        }
        else{
            System.out.println(user.getUsername());
        }

    }


    @RequestMapping(value = "/person_page",method = RequestMethod.GET)
    public String person_page(Model model ){

        model.addAttribute(user);

        return "person_page";
    }







}
