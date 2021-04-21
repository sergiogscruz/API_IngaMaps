package com.tourism.tourism.travel;

import com.tourism.tourism.local.Local;
import com.tourism.tourism.tourist.Tourist;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Travel {
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
  private String reason;

  @Getter
  @Setter
  private Date date;

  @Getter
  @Setter
  @ManyToOne
  private Tourist tourist;

  @Getter
  @Setter
  @ManyToOne
  private Local local;
}
