package com.sv.webscrapper.controller;

import com.sv.webscrapper.domain.dto.UrlDTO;
import com.sv.webscrapper.domain.dto.UrlForm;
import com.sv.webscrapper.service.PageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URL;

@Controller
@RequestMapping("/ui/pages")
@RequiredArgsConstructor
@Slf4j
public class PageUIController {

    private final PageService pageService;

    @GetMapping("")
    public String getPages(Model model) {
        model.addAttribute("pages", pageService.findAllByUserName());
        model.addAttribute("urlForm", new UrlForm());
        model.addAttribute("title", "Web Pages");
        return "page";
    }

    @PostMapping("/submit")
    public String urlSubmit(@ModelAttribute UrlForm urlForm) {
        log.info(urlForm.getLink());
        pageService.savePage(UrlDTO.builder().link(urlForm.getLink()).build());
        return "redirect:/ui/pages";
    }
}
