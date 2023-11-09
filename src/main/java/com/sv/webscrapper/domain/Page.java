package com.sv.webscrapper.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sv.webscrapper.domain.dto.PageDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Page implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "page")
    @JsonIgnoreProperties(value = { "page" }, allowSetters = true)
    private Set<Link> links = new HashSet<>();

    public static Page toEntity(PageDTO pageDTO) {
        return Page.builder().build();
    }

    public static PageDTO toDto(Page page) {
        return PageDTO.builder().build();
    }

}
