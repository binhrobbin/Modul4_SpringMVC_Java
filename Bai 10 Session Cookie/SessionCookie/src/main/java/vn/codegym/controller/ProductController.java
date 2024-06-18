package vn.codegym.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.dto.CartDto;
import vn.codegym.dto.ProductDto;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;

import java.util.Optional;

@Controller
@RequestMapping(value = "/shop")
@SessionAttributes("cart") //khai báo session có tên là 'cart'
public class ProductController {

    /*Khởi tạo giá trị mặc định cho session cart */
    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }

    @Autowired
    ProductService productService;


    @GetMapping
    public ModelAndView showListPage(Model model,
                                     @CookieValue(value = "idProduct",
                                     defaultValue = "-1") Long idProduct) {
        if(idProduct != -1){
            model.addAttribute("historyProduct",
                    productService.findById(idProduct).get());
        }
        return new ModelAndView("product/list", "productList", productService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable long id,
                                   HttpServletResponse response) {
        /* Tạo Coookie */
        Cookie cookie = new Cookie("idProduct", id  + "" );
        cookie.setMaxAge(1 * 24 * 60 * 60); //thời gian tồn tại trong 1 ngày;
//        cookie.setMaxAge(0); //xóa cookie
        cookie.setPath("/");
        response.addCookie(cookie);

        return new ModelAndView("product/detail",
                "product", productService.findById(id).get());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cart){
//                            @ModelAttribute("cart") CartDto cart){
        Optional<Product> productOptional =  productService.findById(id);
        if(productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);

            cart.addProduct(productDto);
        }
        return "redirect:/cart";

    }

}