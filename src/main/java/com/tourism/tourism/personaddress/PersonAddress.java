package com.tourism.tourism.personaddress;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersonAddress {
  @Getter
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id;

  @Getter
	@Setter
  private String country;

  @Getter
	@Setter
  private String state;

  @Getter
	@Setter
  private String city;
}
