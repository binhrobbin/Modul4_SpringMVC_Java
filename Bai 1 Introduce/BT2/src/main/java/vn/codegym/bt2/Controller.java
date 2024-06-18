package vn.codegym.bt2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Set;

@org.springframework.stereotype.Controller

public class Controller {
    static HashMap<String,String> map = new HashMap<>();
    static {
        map.put("banana","Chuối");
        map.put("pen","Bút");
    }
    @GetMapping("")
    public String showInfo() {
        return "index";
    }
    @PostMapping("/change")
    public ModelAndView showInfo2(@RequestParam String a) {
        ModelAndView modelAndView = new ModelAndView("index");
        String check = "";
        Set<String> set = map.keySet();
        for (String key:set){
            if (key.equals(a)) check =key;
        }
        if (check != "") modelAndView.addObject("message", map.get(check));
        else modelAndView.addObject("message", "ko có");
        modelAndView.addObject("a", a);
        return modelAndView;
    }
}
