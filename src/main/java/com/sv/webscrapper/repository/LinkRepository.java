package com.sv.webscrapper.repository;

import com.sv.webscrapper.domain.Link;
import com.sv.webscrapper.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {

    List<Link> findAllByPage(Page page);
    List<Link> findAllByPageAndAndCreatedBy(Page page, String userName);
}
