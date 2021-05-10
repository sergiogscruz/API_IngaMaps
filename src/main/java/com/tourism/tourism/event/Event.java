package com.tourism.tourism.event;

import com.tourism.tourism.local.Local;
import com.tourism.tourism.photo.Photo;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
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
  private String description;

  @Getter
  @Setter
  @NotNull
  private String wayParticipate;

  @Getter
  @Setter
  @NotNull
  private Date startDate;

  @Getter
  @Setter
  @NotNull
  private Date endDate;

  @Getter
  @Setter
  @OneToOne
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  private Photo photo;

  @Getter
  @Setter
  @ManyToOne
  @NotNull
  private Local local;
}
