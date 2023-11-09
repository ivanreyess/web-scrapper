package com.sv.webscrapper.service;

import com.sv.webscrapper.domain.Page;
import com.sv.webscrapper.domain.dto.PageDTO;
import com.sv.webscrapper.domain.dto.UrlDTO;

public interface PageService {

        Page savePage(UrlDTO urlDTO);
}
