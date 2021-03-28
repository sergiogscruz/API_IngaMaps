package com.turismo.turismo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Getter
	@Setter
	@Column(unique = true)
	private String userName;
	
	@Getter
	@Setter
	private String password;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private Role role;
	
}
