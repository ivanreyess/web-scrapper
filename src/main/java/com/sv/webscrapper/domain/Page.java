package com.sv.webscrapper.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sv.webscrapper.domain.dto.PageDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Page implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "page")
    @JsonIgnoreProperties(value = { "page" }, allowSetters = true)
    private Set<Link> links = new HashSet<>();

    @Formula(value = "(SELECT COUNT(*) FROM link l WHERE l.page_id = id)")
    private Long linkCount;

    public static Page toEntity(PageDTO pageDTO) {
        return Page.builder().build();
    }

    public static PageDTO toDto(Page page) {
        return PageDTO.builder()
                .id(page.getId())
                .url(page.getUrl())
                .name(page.getName())
                .build();
    }

}
