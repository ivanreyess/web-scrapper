package com.sv.webscrapper.controller;

import com.sv.webscrapper.domain.Page;
import com.sv.webscrapper.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/links")
@RequiredArgsConstructor
public class LinkUIController {


    private final LinkService linkService;

    @GetMapping("/page/{id}")
    public String getLinks(Model model, @PathVariable Long id) {
        model.addAttribute("links", linkService.findAllByPage(Page.builder().id(id).build()));
        model.addAttribute("title", "Links");
        return "link";
    }
}
