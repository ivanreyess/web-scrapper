package com.sv.webscrapper.service.impl;

import com.sv.webscrapper.domain.Link;
import com.sv.webscrapper.domain.dto.LinkDTO;
import com.sv.webscrapper.repository.LinkRepository;
import com.sv.webscrapper.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.sv.webscrapper.domain.Link.toDto;

@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

    @Override
    public LinkDTO saveLink(Link link) {
        Link savedLink = linkRepository.save(link);
        return toDto(savedLink);
    }
}