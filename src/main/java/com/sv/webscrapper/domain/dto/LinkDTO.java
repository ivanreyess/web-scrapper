package com.sv.webscrapper.domain.dto;

import lombok.Builder;

@Builder
public record LinkDTO(Long id, String name, String url) {

}
