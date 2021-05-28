package com.tourism.tourism.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity(name = "userlogin")
public class UserLogin {
	@Getter
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	@NotNull
	private Long id;
	
	@Getter
	@Setter
	@Column(unique = true)
	@NotNull
	private String username;
	
	@Getter
	@Setter
	@NotNull
	private String password;
	
	@Getter
	@Setter
	@NotNull
	private String name;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	@NotNull
	private Role role;
}
