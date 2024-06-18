package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.codegym.model.Counter;

@Controller
@SessionAttributes("counter")
public class CounterController {

    @ModelAttribute("counter")
    public Counter initCounter(){
        return new Counter();
    }

    @GetMapping
    public String get(@SessionAttribute(value = "counter", required = false) Counter counter) {
        if (counter == null) counter = new Counter();
        else counter.increment();
        return "/index";
    }
}
