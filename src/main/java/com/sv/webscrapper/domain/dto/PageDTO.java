package com.sv.webscrapper.domain.dto;

import lombok.Builder;

@Builder
public record PageDTO(Long id, String name, String url) {
}
