package com.tourism.tourism.evaluation;

import com.tourism.tourism.tourist.Tourist;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evaluation {
  @Getter
  @Id
  @GeneratedValue
  @EqualsAndHashCode.Include
  private Long id;

  @Getter
  @Setter
  private Integer note;

  @Getter
  @Setter
  @ManyToOne
  private Tourist tourist;
}
