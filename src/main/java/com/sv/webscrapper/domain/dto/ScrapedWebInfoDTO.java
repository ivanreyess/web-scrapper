package com.sv.webscrapper.domain.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record ScrapedWebInfoDTO(String webPageName, List<ScrappedLinkDto> scrappedLinkDtos) {
}
