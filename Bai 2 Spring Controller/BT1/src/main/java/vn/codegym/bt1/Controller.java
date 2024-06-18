package vn.codegym.bt1;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping
    public String index() {
        return "index";
    }
    @RequestMapping("/save")
    public String save(@RequestParam String[] check, Model model) {
//        System.out.println(Arrays.toString(check));
        for (int i = 0; i < check.length; i++) {
            model.addAttribute(check[i], check[i]);
        }
        return "index";
    }
}
