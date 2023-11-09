package com.sv.webscrapper.controller;

import com.sv.webscrapper.domain.Page;
import com.sv.webscrapper.domain.dto.LinkDTO;
import com.sv.webscrapper.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/links")
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;
    @GetMapping("/page/{id}")
    public List<LinkDTO> getAll(@PathVariable Long id) {
        return linkService.findAllByPage(Page.builder().id(id).build());
    }

}
