package com.sv.webscrapper.domain;

import com.sv.webscrapper.domain.dto.AuthorityDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "AUTHORITIES")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NonNull
	@Column(unique = true)
	private String authority;

	public static AuthorityDto authorityEntityToDto(Authority authority) {
		return AuthorityDto.builder()
				.id(authority.getId())
				.authority(authority.getAuthority())
				.build();
	}

	public static List<AuthorityDto> authorityListEntityToDto(List<Authority> authorities) {
		return authorities.stream()
				.map(Authority::authorityEntityToDto)
				.toList();
	}

	public static Authority authorityDtoToEntity(AuthorityDto authority) {
		return Authority.builder()
				.id(authority.id())
				.authority(authority.authority())
				.build();
	}

	public static List<Authority> authorityListDtoToEntity(List<AuthorityDto> authorities) {
		return authorities.stream()
				.map(authority -> authorityDtoToEntity(authority))
				.toList();
	}
}