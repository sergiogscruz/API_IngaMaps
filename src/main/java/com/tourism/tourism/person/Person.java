package com.tourism.tourism.person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.tourism.tourism.person.enums.PersonType;
import com.tourism.tourism.personaddress.PersonAddress;
import com.tourism.tourism.photo.Photo;
import com.tourism.tourism.userlogin.UserLogin;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  @Getter
  @Id
  @GeneratedValue
  @EqualsAndHashCode.Include
  @NotNull
  private Long id;

  @Getter
  @Setter
  @NotNull
  private String name;

  @Getter
  @Setter
  @Enumerated(EnumType.STRING)
  @NotNull
  private PersonType personType;

  @Getter
  @Setter
  @OneToOne
  @NotNull
  private UserLogin userLogin;

  @Getter
  @Setter
  @OneToOne
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  private Photo photo;

  @Getter
  @Setter
  @OneToOne
  private PersonAddress personAddress;
}
