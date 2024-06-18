package vn.codegym.bt1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.bt1.model.Product;
import vn.codegym.bt1.service.IProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"","/product"})
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public String home(Model model){
        System.out.println(1);
       List<Product> productList = productService.findAll();
       model.addAttribute("productList", productList);
//        model.addAttribute("searched", "");
//        model.addAttribute("keyword", "");
       return "home";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam(value = "keyword") String keyword, Model model){
//        if (!keyword.isEmpty()) {
//            List<Product> productList = productService.search(keyword);
//            if (productList.isEmpty()) {
//                model.addAttribute("message", "there is no name containing in the list");
//            } else {
//                model.addAttribute("productList", productList);
//                model.addAttribute("searched", keyword);
//            }
//            return "home";
//        }else return "redirect:/product";
//    }

    @GetMapping("/search")
    public String search(String keyword, Model model){
        if (!keyword.isEmpty()) {
            List<Product> productList = productService.search(keyword);
            if (productList.isEmpty()) {
                model.addAttribute("message", "there is no name containing in the list");
            } else {
                model.addAttribute("productList", productList);
                model.addAttribute("keyword", keyword);
            }
            return "home";
        }else return "redirect:/product";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes){
        product.setId((int) (Math.random()*100+5));
        redirectAttributes.addFlashAttribute("message","create success");
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/view")
    public String view(@RequestParam int id,Model model){
        model.addAttribute("product", productService.findByID(id));
        return "view";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("product", productService.findByID(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","edit success");
        productService.update(product.getId(),product);
        return "redirect:/product";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","delete success");
        productService.remove(id);
        return "redirect:/product";
    }
}
