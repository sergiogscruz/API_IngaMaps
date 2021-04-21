package com.tourism.tourism.comment;

import com.tourism.tourism.local.Local;
import com.tourism.tourism.tourist.Tourist;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
  @Getter
  @Id
  @GeneratedValue
  @EqualsAndHashCode.Include
  private Long id;

  @Getter
  @Setter
  private String comment;

  @Getter
  @Setter
  @ManyToOne
  private Tourist tourist;

  @Getter
  @Setter
  @ManyToOne
  private Local local;
}
