package com.sv.webscrapper.service.impl;

import com.sv.webscrapper.domain.Link;
import com.sv.webscrapper.domain.Page;
import com.sv.webscrapper.domain.dto.ScrapedWebInfoDTO;
import com.sv.webscrapper.domain.dto.UrlDTO;
import com.sv.webscrapper.repository.PageRepository;
import com.sv.webscrapper.service.LinkService;
import com.sv.webscrapper.service.PageService;
import com.sv.webscrapper.service.WebScrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;
    private final LinkService linkService;
    private final WebScrapperService webScrapperService;
    @Override
    public Page savePage(UrlDTO urlDTO) {

        ScrapedWebInfoDTO scrapedWebInfoDTO = webScrapperService.scrape(urlDTO.link());
        Page page = new com.sv.webscrapper.domain.Page();
        page.setName(scrapedWebInfoDTO.webPageName());
        page.setUrl(urlDTO.link());
        page = pageRepository.save(page);
        Page finalPage = page;
        scrapedWebInfoDTO.scrappedLinkDtos().forEach(l -> linkService.saveLink(Link.builder().url(l.url()).name(l.name()).page(finalPage).build()));
        return null;
    }
}
