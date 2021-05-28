package com.tourism.tourism.personaddress;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PersonAddress {
  @Getter
  @Id
  @GeneratedValue
  @EqualsAndHashCode.Include
  @NotNull
  private Long id;

  @Getter
  @Setter
  @NotNull
  private String country;

  @Getter
  @Setter
  @NotNull
  private String state;

  @Getter
  @Setter
  @NotNull
  private String city;
}
