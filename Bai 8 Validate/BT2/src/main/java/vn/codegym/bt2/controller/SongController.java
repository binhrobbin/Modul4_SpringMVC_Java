package vn.codegym.bt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.bt2.model.Song;
import vn.codegym.bt2.service.SongServiceImpl;

import java.util.Optional;

@Controller
@RequestMapping()
public class SongController {
    @Autowired
    private SongServiceImpl service;

    @GetMapping()
    public ModelAndView showList(@PageableDefault (value = 3) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("songList",service.findAll(pageable));
        return modelAndView;
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("song", new Song());
        return "create";
    }
    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) return "create";
        service.save(song);
        redirectAttributes.addFlashAttribute("message", "Create new song successfully");
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id,Model model){
        Optional<Song> songOptional = service.findByID(id);
        if (songOptional.isPresent()){
            model.addAttribute("song", songOptional.get());
            return "update";
        }
        return "/";
    }
    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) return "/update";
        service.save(song);
        redirectAttributes.addFlashAttribute("message", "Create new song successfully");
        return "redirect:/";
    }
}
