package com.tourism.tourism.local;

import com.tourism.tourism.address.Address;
import com.tourism.tourism.photo.Photo;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Local {
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
  private String description;

  @Getter
  @Setter
  @Enumerated(EnumType.STRING)
  private LocalCategory category;

  @Getter
  @Setter
  @OneToMany
  private List<Photo> photos;

  @Getter
  @Setter
  @OneToOne
  private Address address;
}
