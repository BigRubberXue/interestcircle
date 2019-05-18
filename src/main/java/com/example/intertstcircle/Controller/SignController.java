package com.example.intertstcircle.Controller;



import com.example.intertstcircle.Service.ArticlesService;
import com.example.intertstcircle.Service.UserSignService;
import com.example.intertstcircle.User.Articles;
import com.example.intertstcircle.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/sign")
public class SignController {

    public String uname;
    public String pwd;
    public String sure_pwd;


    @Autowired
    public UserSignService userSignService;

    @Autowired
    public ArticlesService articlesService;

    @Autowired
    public User user;

    @Autowired
    public List<Articles> articles;


    @RequestMapping(value = "/signin",method = RequestMethod.GET)
    public String signin_get(Model model) {
        //登陆
        return "signin";
    }


    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public String signin_post(HttpServletRequest req,Model model){
        //登陆
        uname = req.getParameter("username");
        pwd = req.getParameter("password");
        user.setUsername(uname);
        user.setPassword(pwd);
        if(userSignService.checkUserExist(user)){
            HttpSession session = req.getSession();
            session.setAttribute("User",user);
            articles=articlesService.getAllarticles();
            model.addAttribute("articles",articles);
            return "main";
        }
        return "signin";
    }


    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String main_view(Model model){
        model.addAttribute("articles",articles);
        return "main";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String signup_get(Model model){
        //注册
        return "signup";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public String signup_post(Model model,HttpServletRequest req){
        //注册
        uname = req.getParameter("username");
        pwd = req.getParameter("password");
        sure_pwd=req.getParameter("sure_pwd");
        if(pwd.equals(sure_pwd)){
            user.setUsername(uname);
            user.setPassword(pwd);
            if(userSignService.selectUsercount(user)!=0){
                model.addAttribute("msg","had_signup");
                return "signup";
            }
            userSignService.insertUser(user);
            HttpSession session = req.getSession();
            session.setAttribute("User",user);
            articles=articlesService.getAllarticles();
            model.addAttribute("articles",articles);
            return "main";
        }
        else{
            sure_pwd = null;
            return "signup";
        }

    }
    @RequestMapping("/forgot")
    public String forgot(Model model){
        return "forgot";
    }


}