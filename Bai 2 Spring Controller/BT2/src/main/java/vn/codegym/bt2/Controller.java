package vn.codegym.bt2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping
    public String index() {
        return "index";
    }
    @RequestMapping("/result")
    public String save(@RequestParam int left,
                       @RequestParam int right,
                       @RequestParam String btn,
                       Model model) {
        switch (btn) {
            case "Addition(+)":
                model.addAttribute("result", left+right);
                model.addAttribute("btn", "Addition(+)");
                break;
            case "Subtraction(-)":
                model.addAttribute("result", left-right);
                model.addAttribute("btn", "Subtraction(-)");
                break;
            case "Multiplication(x)":
                model.addAttribute("result", left*right);
                model.addAttribute("btn", "Multiplication(x)");
                break;
            case "Division(/)":
                try {
                    model.addAttribute("result", left / right);
                    model.addAttribute("btn", "Division(/)");
                }catch (Exception e){
                    model.addAttribute("btn", "lỗi chia cho không");
                    return "index";
                }
                break;
        }
        return "index";
    }
}
