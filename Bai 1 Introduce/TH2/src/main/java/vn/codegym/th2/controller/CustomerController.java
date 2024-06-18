package vn.codegym.th2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.th2.model.Customer;
import vn.codegym.th2.service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//    @GetMapping("/customers")
//    public String showList() {
//        return "info";
//    }
//    @GetMapping("/customers")
//    public String showList(Model model) {
//        List<Customer> customers = customerService.findAll();
//        model.addAttribute("customers", customers);
//        return "customers/list.jsp";
//    }

    @RequestMapping (value = "/customers", method = RequestMethod.GET)
    public ModelAndView showInfo() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
//        @GetMapping("/info")
//        public ModelAndView showInfo(@RequestParam int id) {
//            ModelAndView modelAndView = new ModelAndView("info");
//            Customer customer = customerService.findByID(id);
//            modelAndView.addObject("customer", customer);
//            return modelAndView;
//        }
//        @GetMapping
//        public ModelAndView showList() {
//        ModelAndView modelAndView = new ModelAndView("list");
//        List<Customer> customers = customerService.findAll();
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//        }

    @GetMapping("/customers/info")
    public ModelAndView showInfo(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("info");
        Customer customer = customerService.findByID(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
}