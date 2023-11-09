package com.sv.webscrapper.controller;

import com.sv.webscrapper.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/pages")
@RequiredArgsConstructor
public class PageUIController {

    private final PageService pageService;

    @GetMapping("")
    public String getPages(Model model) {
        model.addAttribute("pages", pageService.findAll());
        return "page";
    }

    @GetMapping("/test")
    public String test(Model model) {
//        model.addAttribute("pages", pageService.findAll());
        return "test";
    }
}
