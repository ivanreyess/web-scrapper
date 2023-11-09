package com.sv.webscrapper.repository;

import com.sv.webscrapper.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
