package com.example.intertstcircle.Controller;

import com.example.intertstcircle.Service.ArticlesService;
import com.example.intertstcircle.Service.PersonService;
import com.example.intertstcircle.Service.UserSignService;
import com.example.intertstcircle.User.Articles;
import com.example.intertstcircle.User.User;
import com.example.intertstcircle.User.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/index")
public class PageController {

    @Autowired
    public User user;

   /* @Autowired
    public ArticlesService articlesService;*/

    @Autowired
    public PersonService personService;

    @Autowired
    public List<Articles> articles;

    @ModelAttribute
    public void init(HttpSession session){
        user=(User)session.getAttribute("User");
      //  articles=articlesService.getAllarticles();
    }

    @RequestMapping(value = "/person_page",method = RequestMethod.GET)
    public String person_page(Model model) {
        //User myuser = personService.mymessage(user);
        model.addAttribute("user", user);
        return "person_page";
    }

    @RequestMapping(value = "/person_change",method = RequestMethod.POST)
    public String changeMessage(Model model, HttpServletRequest request){
        String address=request.getParameter("address");
        String phone=request.getParameter("phone");
        String mail=request.getParameter("mail");
        String job=request.getParameter("job");
        UserMessage msg = new UserMessage(user.getUser_id(),address,phone,mail,job);
        personService.UpdateMyMessage(msg);
        return "person_page";
    }

    @RequestMapping(value = "/person_change",method = RequestMethod.GET)
    public String person_change(Model model){
        UserMessage msg = personService.getUserMessage(user);
        model.addAttribute("my_msg",msg);
        return "person_change";
    }

    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public String about(Model model){
        return "about";
    }

}
