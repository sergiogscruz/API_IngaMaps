package com.tourism.tourism.person;

import javax.persistence.*;

import com.tourism.tourism.personaddress.PersonAddress;
import com.tourism.tourism.photo.Photo;
import com.tourism.tourism.user.User;
import lombok.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {
  @Getter
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id;

  @Getter
	@Setter
  private String name;

  @Getter
  @Setter
  @Enumerated(EnumType.STRING)
  private PersonType personType;

  @Getter
  @Setter
  @OneToOne
  private User user;

  @Getter
  @Setter
  @OneToOne
  private Photo photo;

  @Getter
	@Setter
  @OneToOne
  private PersonAddress personAddress;
}
