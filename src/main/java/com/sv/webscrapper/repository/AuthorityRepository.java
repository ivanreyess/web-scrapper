package com.sv.webscrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sv.webscrapper.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    public Authority findByAuthority(String authority);

}
