package com.sv.webscrapper.controller;

import com.sv.webscrapper.domain.dto.PageDTO;
import com.sv.webscrapper.domain.dto.PageResponseDto;
import com.sv.webscrapper.domain.dto.UrlDTO;
import com.sv.webscrapper.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pages")
@RequiredArgsConstructor
public class PageController {

    private final PageService pageService;

    @PostMapping("")
    public void generateLinks(@RequestBody UrlDTO url) {
        pageService.savePage(url);
    }

    @GetMapping("")
    public List<PageResponseDto> getAll() {
        return pageService.findAll();
    }
}
