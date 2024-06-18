package vn.codegym.th2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.th2.model.Customer;
import vn.codegym.th2.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping({"/customers",""})
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//    @RequestMapping (value = "/customers", method = RequestMethod.GET)
    @GetMapping()
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
//    @GetMapping("/customers/info")
    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("info");
        Customer customer = customerService.findByID(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @PostMapping
    public String updateCustomer(@RequestParam int id,
                                 @RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String address,
                                 RedirectAttributes redirectAttributes){
    Customer customer = new Customer(id,name,email,address);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","The product was successfully added.");
        return "redirect:/customers";
    }
}