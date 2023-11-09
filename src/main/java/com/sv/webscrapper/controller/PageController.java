package com.sv.webscrapper.controller;

import com.sv.webscrapper.domain.dto.UrlDTO;
import com.sv.webscrapper.service.PageService;
import com.sv.webscrapper.service.WebScrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PageController {

    private final PageService pageService;

    @PostMapping("/pages")
    public void generateLinks(@RequestBody UrlDTO url) {
        pageService.savePage(url);
    }
}
