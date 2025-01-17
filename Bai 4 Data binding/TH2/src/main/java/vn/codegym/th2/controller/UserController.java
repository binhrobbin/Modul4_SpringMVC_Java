package vn.codegym.th2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.th2.model.Login;
import vn.codegym.th2.model.User;
import vn.codegym.th2.model.UserDao;

@Controller
public class UserController {
    @GetMapping({"/home",""})
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("login", new Login());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = UserDao.checkLogin(login);
        ModelAndView modelAndView;
        if(user == null){
            modelAndView = new ModelAndView("error");
        }else {
            modelAndView = new ModelAndView("user");
            modelAndView.addObject("user",user);
        }
        return modelAndView;
    }
}
