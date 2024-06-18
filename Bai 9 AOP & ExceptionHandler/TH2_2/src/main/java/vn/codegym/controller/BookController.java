package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.service.BookServiceImpl;

@Controller
@RequestMapping ("/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    @GetMapping()
    public String showBook(@PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("bookList", bookService.findAll(pageable));
        return "list";
    }

}
