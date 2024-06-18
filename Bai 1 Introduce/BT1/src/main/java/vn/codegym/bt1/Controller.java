package vn.codegym.bt1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller

public class Controller {
    @GetMapping("")
    public String showInfo() {
        return "index";
    }
    @PostMapping("/change")
    public ModelAndView showInfo2(@RequestParam String a, String b) {
        ModelAndView modelAndView = new ModelAndView("index");
        int vnd = Integer.parseInt(a) * Integer.parseInt(b);
        modelAndView.addObject("message", vnd);
        modelAndView.addObject("a", a);
        modelAndView.addObject("b", b);
        return modelAndView;
    }
}
