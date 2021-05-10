package com.tourism.tourism.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

import java.util.UUID;

@Entity(name = "userlogin")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
	@Getter
	@Id
	@EqualsAndHashCode.Include
	@NotNull
	private String id;
	
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

	public User(){
		this.id = UUID.randomUUID().toString();
	}
}
