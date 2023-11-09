package com.sv.webscrapper.service.impl;

import com.sv.webscrapper.repository.PageRepository;
import com.sv.webscrapper.service.PageService;
import com.sv.webscrapper.service.WebScrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;
    private final WebScrapperService webScrapperService;
    @Override
    public Page savePage(Page page) {


        return null;
    }
}
