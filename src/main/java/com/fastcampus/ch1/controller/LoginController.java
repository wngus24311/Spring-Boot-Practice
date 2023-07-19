package com.fastcampus.ch1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URLEncoder;

@RequestMapping("/login")
@Controller
public class LoginController {
//    @RequestMapping(value = "/login")
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

//    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @PostMapping("/login")
    public String login(String id, String pwd, Model model) throws Exception {
        if (loginCheck(id, pwd)) {
            model.addAttribute("id", id);
            model.addAttribute("pwd", pwd);
            return "/userInfo";
        } else {
            String msg = URLEncoder.encode("id 또는 password가 일치하지 않습니다.", "utf-8");
            return "redirect:/login/login?msg=" + msg;
        }
    }

    private boolean loginCheck(String id, String pwd) {
        return id.equals("asdf") && pwd.equals("1234");
    }
}
