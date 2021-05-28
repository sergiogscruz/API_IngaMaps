package com.tourism.tourism.contact;

import com.tourism.tourism.contact.enums.ContactCategory;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {
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
  @NotNull
  private String email;

  @Getter
  @Setter
  @NotNull
  private String description;

  @Getter
  @Setter
  @NotNull
  private String phoneNumber;

  @Getter
  @Setter
  @Enumerated(EnumType.STRING)
  @NotNull
  private ContactCategory category;
}