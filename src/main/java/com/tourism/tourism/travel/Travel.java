package com.tourism.tourism.travel;

import com.tourism.tourism.local.Local;
import com.tourism.tourism.tourist.Tourist;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Travel {
  @Getter
  @Id
  @GeneratedValue
  @EqualsAndHashCode.Include
  @NotNull
  private Long id;

  @Getter
  @Setter
  private String comment;

  @Getter
  @Setter
  @NotNull
  private String reason;

  @Getter
  @Setter
  @NotNull
  private Date date;

  @Getter
  @Setter
  @ManyToOne
  @NotNull
  private Tourist tourist;

  @Getter
  @Setter
  @ManyToOne
  @NotNull
  private Local local;
}
