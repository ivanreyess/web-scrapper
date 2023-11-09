package com.sv.webscrapper.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sv.webscrapper.domain.dto.LinkDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Link implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "link" }, allowSetters = true)
    private Page page;

    public static Link toEntity(LinkDTO linkDTO) {
        return Link.builder()
                .id(linkDTO.id())
                .url(linkDTO.url())
//                .page()
                .build();
    }

    public static LinkDTO toDto(Link link) {
        return LinkDTO.builder().build();
    }
}
