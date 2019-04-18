package com.example.intertstcircle.Controller;



import com.example.intertstcircle.Service.UserSignService;
import com.example.intertstcircle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/sign")
public class SignController {

    public String uname;
    public String pwd;
    public String sure_pwd;

    @Autowired
    public UserSignService userSignService;

    @Autowired
    public User user;

    @RequestMapping(value = "/signin",method = RequestMethod.GET)
    public String signin_get(ModelMap map){
        return "signin";
    }

    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public String signin_post(HttpServletRequest req){
        uname = req.getParameter("username");
        pwd = req.getParameter("password");
        user.setUsername(uname);
        user.setPassword(pwd);
        if(userSignService.checkUserExist(user)){
            return "redirect:/sign/main";
        }
        return "redirect:/sign/signin";
    }


    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String main_view(ModelMap map){
        map.addAttribute("username",uname);
        map.addAttribute("password",pwd);
        return "main";
    }



    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String signip_get(ModelMap map){
        return "signup";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public String signup_post(HttpServletRequest req){
        uname = req.getParameter("username");
        pwd = req.getParameter("password");
        sure_pwd=req.getParameter("sure_pwd");
        if(pwd.equals(sure_pwd)){
            user.setUsername(uname);
            user.setPassword(pwd);
            if(userSignService.selectUsercount(user)!=0){
                return "redirect:/sign/signup";
            }
            userSignService.insertUser(user);
            return "redirect:/sign/main";
        }
        else{
            sure_pwd = null;
            return "redirect:/sign/signup";
        }


    }

    @RequestMapping("/forgot")
    public String forgot(ModelMap map){
        return "forgot";
    }





}
