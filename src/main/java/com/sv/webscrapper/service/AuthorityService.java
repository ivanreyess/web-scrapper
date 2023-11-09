package com.sv.webscrapper.service;

import com.sv.webscrapper.domain.Authority;
import com.sv.webscrapper.domain.dto.AuthorityDto;

import java.util.List;

public interface AuthorityService {

    public AuthorityDto getAuthorityById(Integer id);

    public List<AuthorityDto> getAllAuthorities();

    public AuthorityDto createAuthority(Authority authority);

    public AuthorityDto updateAuthority(Authority authority);

    public void deleteAuthority(Authority authority);
}
