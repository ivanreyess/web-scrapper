package com.sv.webscrapper.domain.dto;

import lombok.Builder;

@Builder
public record ScrappedLinkDto(String url, String name) {
}
