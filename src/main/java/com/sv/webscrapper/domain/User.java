package com.sv.webscrapper.domain;

import com.sv.webscrapper.domain.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@Column(unique = true)
	private String username;
	@NonNull
	private String password;

	@Singular
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "users_authorities", joinColumns = {
			@JoinColumn(name = "USERS_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHORITIES_ID", referencedColumnName = "ID") })
	private List<Authority> authorities;

	@Builder.Default
	private Boolean accountNonExpired = true;
	@Builder.Default
	private Boolean accountNonLocked = true;
	@Builder.Default
	private Boolean credentialsNonExpired = true;
	@Builder.Default
	private Boolean enabled = true;

	private String firstName;
	private String lastName;
	private String emailAddress;
	private LocalDate birthdate;

	public static UserDto userEntityToDto(User user) {
		return UserDto.builder()
				.id(user.getId())
				.username(user.getUsername())
				.authorities(Authority.authorityListEntityToDto(user.getAuthorities()))
				.accountNonExpired(user.getAccountNonExpired())
				.accountNonLocked(user.getAccountNonLocked())
				.credentialsNonExpired(user.getCredentialsNonExpired())
				.enabled(user.getEnabled())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.emailAddress(user.getEmailAddress())
				.birthdate(user.getBirthdate())
				.build();
	}

	public static List<UserDto> userListEntityToDto(List<User> users) {
		return users.stream()
				.map(user -> userEntityToDto(user))
				.toList();
	}

	public static User userDtoToEntity(UserDto user, String password) {
		return User.builder()
				.id(user.id())
				.username(user.username())
				.password(password)
				.authorities(Authority.authorityListDtoToEntity(user.authorities()))
				.accountNonExpired(user.accountNonExpired())
				.accountNonLocked(user.accountNonLocked())
				.credentialsNonExpired(user.credentialsNonExpired())
				.enabled(user.enabled())
				.firstName(user.firstName())
				.lastName(user.lastName())
				.emailAddress(user.emailAddress())
				.birthdate(user.birthdate())
				.build();
	}

	public static List<User> userListDtoToEntity(List<UserDto> users, String password) {
		return users.stream()
				.map(user -> userDtoToEntity(user, password))
				.toList();
	}
}