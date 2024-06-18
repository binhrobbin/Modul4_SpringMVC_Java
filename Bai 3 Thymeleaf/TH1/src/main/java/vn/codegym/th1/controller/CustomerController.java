package vn.codegym.th1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.th1.model.Customer;
import vn.codegym.th1.service.ICustomerService;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String index(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","create success");
        customer.setId((int) (Math.random()*100));
        customerService.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("/{id}/edit")
    public String edit (@PathVariable int id,Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "/update";
    }
    @PostMapping("/update")
    public String update(Customer customer,RedirectAttributes redirectAttributes){
        customerService.update(customer.getId(),customer);
        redirectAttributes.addFlashAttribute("message","update success");
        return "redirect:/customers";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes){
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success","delete success");
        return "redirect:/customers";
    }
    @GetMapping("/view")
    public String viewInfo(@RequestParam int id,Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}
