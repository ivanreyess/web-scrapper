package com.sv.webscrapper.service;

import com.sv.webscrapper.domain.Authority;
import com.sv.webscrapper.domain.dto.AuthorityDto;

import java.util.List;

public interface AuthorityService {

    AuthorityDto getAuthorityById(Integer id);

    List<AuthorityDto> getAllAuthorities();

    AuthorityDto createAuthority(Authority authority);

    AuthorityDto updateAuthority(Authority authority);

    void deleteAuthority(Authority authority);

    AuthorityDto findByAuthority(String authority);

}
