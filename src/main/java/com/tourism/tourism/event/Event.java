package com.tourism.tourism.event;

import com.tourism.tourism.local.Local;
import com.tourism.tourism.photo.Photo;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
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
  private String wayParticipate;

  @Getter
  @Setter
  private Date startDate;

  @Getter
  @Setter
  private Date endDate;

  @Getter
  @Setter
  @OneToOne
  private Photo photo;

  @Getter
  @Setter
  @ManyToOne
  private Local local;
}
