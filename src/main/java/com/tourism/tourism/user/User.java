package com.tourism.tourism.user;

import javax.persistence.*;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
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
	@Enumerated(EnumType.STRING)
	private Role role;
}
