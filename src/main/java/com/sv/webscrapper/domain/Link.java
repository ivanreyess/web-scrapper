package com.sv.webscrapper.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sv.webscrapper.domain.dto.LinkDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
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

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;

    public static Link toEntity(LinkDTO linkDTO) {
        return Link.builder()
                .id(linkDTO.id())
                .url(linkDTO.url())
//                .page()
                .build();
    }

    public static LinkDTO toDto(Link link) {
        return LinkDTO.builder()
                .id(link.getId())
                .name(link.getName())
                .url(link.getUrl())
                .build();
    }
}
