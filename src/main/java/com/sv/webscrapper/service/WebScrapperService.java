package com.sv.webscrapper.service;

import com.sv.webscrapper.domain.dto.ScrapedWebInfoDTO;

public interface WebScrapperService {

    ScrapedWebInfoDTO scrape(String url);
}
