package com.example.sing_and_song.controller;

import com.example.sing_and_song.model.WebSong;
import com.example.sing_and_song.service.IWebSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/sing")
public class WebSongController {
    @Autowired
    IWebSongService webSongService;

    @GetMapping("")
    public String blogList(@RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String searchName,
                           Model model) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("song_name").descending());
        Page<WebSong> webSong = webSongService.searchByName(pageable, searchName);
        model.addAttribute("webSong", webSong);
        model.addAttribute("searchName", searchName);
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("webSong", new WebSong());
        return "create";
    }

    @PostMapping("/create")
    public String createSong(@Validated WebSong webSong, BindingResult bindingResult, Model model) {
        webSong.validate(webSong, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            webSongService.saveSong(webSong);
            model.addAttribute("message", "ADD SUCCESSFULLY");
            return "result";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEdit(Model model, @PathVariable int id) {
        model.addAttribute("webSong", webSongService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editSong(@Validated WebSong webSong, BindingResult bindingResult, Model model) {
        webSong.validate(webSong, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            webSongService.updateSong(webSong,webSong.getId());
            model.addAttribute("message", "EDIT SUCCESSFULLY");
            return "result";
        }
    }
}
