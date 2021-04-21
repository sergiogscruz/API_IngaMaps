package com.tourism.tourism.contact;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {
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
  private String email;

  @Getter
  @Setter
  private String description;

  @Getter
  @Setter
  private String phoneNumber;

  @Getter
  @Setter
  @Enumerated(EnumType.STRING)
  private ContactCategory category;
}