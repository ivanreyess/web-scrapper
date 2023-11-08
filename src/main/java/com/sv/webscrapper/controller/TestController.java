package com.sv.webscrapper.controller;


import com.sv.webscrapper.domain.dto.UrlDTO;
import com.sv.webscrapper.service.WebScrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final WebScrapperService webScrapperService;

    @PostMapping("/generate")
    public void generateLinks(@RequestBody UrlDTO url) {
        webScrapperService.scrape(url.link());
    }

}
