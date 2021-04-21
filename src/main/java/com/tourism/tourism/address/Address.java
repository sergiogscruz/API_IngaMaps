package com.tourism.tourism.address;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
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

  @Getter
  @Setter
  private String neighborhood;

  @Getter
  @Setter
  private String number;

  @Getter
  @Setter
  private String street;

  @Getter
  @Setter
  private String complement;
}
