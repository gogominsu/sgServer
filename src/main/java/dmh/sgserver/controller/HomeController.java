package dmh.sgserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homepage(){
        return "home";
    }
    @GetMapping("/aaa")
    public String apaage() {return "login_resist_form";}
    @GetMapping("/signin")
    public String signIn(){
        return "signin";
    }
    @GetMapping("/signup")
    public String signUp(){
        return "signup";
    }
    @GetMapping("/members")
    public String members(){
        return "members";
    }
    @GetMapping("/login")
    public String login(){
        return "login_resist_form";
    }
}
