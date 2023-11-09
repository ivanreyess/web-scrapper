package com.sv.webscrapper.repository;

import com.sv.webscrapper.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

}
