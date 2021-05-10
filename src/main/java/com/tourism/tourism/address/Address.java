package com.tourism.tourism.address;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
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

  @Getter
  @Setter
  @NotNull
  private String neighborhood;

  @Getter
  @Setter
  @NotNull
  private String number;

  @Getter
  @Setter
  @NotNull
  private String street;

  @Getter
  @Setter
  private String complement;
}
