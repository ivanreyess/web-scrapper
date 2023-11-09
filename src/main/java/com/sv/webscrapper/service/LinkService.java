package com.sv.webscrapper.service;

import com.sv.webscrapper.domain.Link;
import com.sv.webscrapper.domain.dto.LinkDTO;
import org.springframework.stereotype.Service;

public interface LinkService {
    LinkDTO saveLink(Link link);
}
