package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Book;
import vn.codegym.model.Note;
import vn.codegym.service.BookServiceImpl;
import vn.codegym.service.NoteServiceImpl;

import java.util.Optional;

@Controller
@RequestMapping ("/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private NoteServiceImpl noteService;

    @GetMapping()
    public String showBook(@PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("bookList", bookService.findAll(pageable));
        return "list";
    }

    @GetMapping("/notes")
    public String showNotes(Model model){
        model.addAttribute("noteList", noteService.findAll());
        return "noteList";
    }

    @GetMapping("/search")
    public ModelAndView listCustomersSearch(@RequestParam(value = "search") Optional<String> search, Pageable pageable){
        Page<Book> bookList;
        ModelAndView modelAndView = new ModelAndView("list");
        if(search.isPresent()){
            bookList = bookService.findAllByFirstNameContaining(pageable, search.get());
            modelAndView.addObject("keyword", search.get());
        } else {
            bookList = bookService.findAll(pageable);
        }
        modelAndView.addObject("bookList", bookList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "Create new book successfully");
        return "redirect:/book";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable int id) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("update");
            modelAndView.addObject("book", book.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("book") Book book,
                         RedirectAttributes redirect) {
        bookService.save(book);
        redirect.addFlashAttribute("message", "Update book successfully");
        return "redirect:/book";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,
                         RedirectAttributes redirect) {
        bookService.remove(id);
        redirect.addFlashAttribute("message", "Delete book successfully");
        return "redirect:/book";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailForm(@PathVariable int id) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("book", book.get());
        return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/borrow/{id}")
    public String detail(@ModelAttribute("book") Book book, Model model) {
        if (book.getQuantity() != 0) {
            book.setQuantity(book.getQuantity()-1);
            bookService.save(book);
            int code = (int) (Math.random() * 99999);
            noteService.save(new Note(code, book));
            model.addAttribute("message", code);
            model.addAttribute("message2", book.getName());
            return "showCode";
        }
        model.addAttribute("message", "Hết sách");
        return "error_404";
    }

    @PostMapping("/return/{id}")
    public String returnForm(@PathVariable int id, Model model) {
        Optional <Book> book = bookService.findById(id);
        Note note = new Note(book.get());
        model.addAttribute("note",note);
//        model.addAttribute("book",book);
            return "return";
    }
    @PostMapping("/return2")
    public String returnBook(@ModelAttribute("note") Note note, RedirectAttributes redirectAttributes,Model model) {
        Optional<Note> optionalNote = noteService.findByCode(note.getCode());
//        Optional <Book> book = bookService.findById(note.getBook().getId());
        if (optionalNote.isPresent() && note.getBook().getId() == optionalNote.get().getBook().getId()){
            note.getBook().setQuantity(note.getBook().getQuantity()+1);
            bookService.save(note.getBook());
            noteService.remove(optionalNote.get().getId());
            redirectAttributes.addFlashAttribute("message","trả sách thành công");
            return "redirect:/book";
        }
        model.addAttribute("message", "Sai mã");
        return "error_404";
    }
}
