package com.sv.webscrapper.repository;

import com.sv.webscrapper.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Long, Page> {
}
