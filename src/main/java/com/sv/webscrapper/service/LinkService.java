package com.sv.webscrapper.service;

import com.sv.webscrapper.domain.Link;
import com.sv.webscrapper.domain.Page;
import com.sv.webscrapper.domain.dto.LinkDTO;

import java.util.List;

public interface LinkService {
    LinkDTO saveLink(Link link);

    List<LinkDTO> findAll();

    List<LinkDTO> findAllByPage(Page page);

    List<LinkDTO> findAllByPageAndUserName(Page page);

}
