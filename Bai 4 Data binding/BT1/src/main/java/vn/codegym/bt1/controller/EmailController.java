package vn.codegym.bt1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.bt1.model.Email;
import vn.codegym.bt1.service.IEmailService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {
    @Autowired
    IEmailService emailService;

    @GetMapping()
    public String showEmail(Model model){
        List<Email> emailList = emailService.findAll();
        Email email = emailList.get(0);
        model.addAttribute("email",email);
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        model.addAttribute("languageList",languageList);
        List<Integer> sizeList = new ArrayList<>();
        sizeList.add(5);
        sizeList.add(10);
        sizeList.add(15);
        sizeList.add(25);
        sizeList.add(50);
        sizeList.add(100);
        model.addAttribute("sizeList",sizeList);
        return "setting";
    }
    @PostMapping("/update")
    public String update(@RequestParam String language,
                         @RequestParam int pageSize,
                         @RequestParam String checkbox,
                         @RequestParam String textarea,
                         @RequestParam String sub,
                         Model model){
        if (sub == "Update") {
            Email email = new Email(language, pageSize, checkbox, textarea);
            emailService.update(email);
            model.addAttribute("email", email);
            List<String> languageList = new ArrayList<>();
            languageList.add("English");
            languageList.add("Vietnamese");
            languageList.add("Japanese");
            languageList.add("Chinese");
            model.addAttribute("languageList", languageList);
            List<Integer> sizeList = new ArrayList<>();
            sizeList.add(5);
            sizeList.add(10);
            sizeList.add(15);
            sizeList.add(25);
            sizeList.add(50);
            sizeList.add(100);
            model.addAttribute("sizeList", sizeList);
            model.addAttribute("message", "update success");
            return "setting";
        }else {
            return "redirect:/setting";
        }
    }
}
