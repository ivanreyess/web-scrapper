package com.sv.webscrapper.service;

import com.sv.webscrapper.domain.Page;
import com.sv.webscrapper.domain.dto.PageDTO;
import com.sv.webscrapper.domain.dto.PageResponseDto;
import com.sv.webscrapper.domain.dto.UrlDTO;

import java.util.List;

public interface PageService {

        Page savePage(UrlDTO urlDTO);

        List<PageResponseDto> findAll();

        List<PageResponseDto> findAllByUserName();
}
