package com.sv.webscrapper.repository;

import com.sv.webscrapper.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    List<Page> findAllByCreatedBy(String userName);
}
