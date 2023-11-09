package com.sv.webscrapper.domain.dto;


import lombok.Builder;


@Builder
public record PageResponseDto(Long id, String name, Long numberOfLinks) {
}
