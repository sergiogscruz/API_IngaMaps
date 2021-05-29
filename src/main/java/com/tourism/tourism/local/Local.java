package com.tourism.tourism.local;

import com.tourism.tourism.address.Address;
import com.tourism.tourism.comment.Comment;
import com.tourism.tourism.evaluation.Evaluation;
import com.tourism.tourism.local.enums.LocalCategory;
import com.tourism.tourism.photo.Photo;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Local {
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
  @Enumerated(EnumType.STRING)
  @NotNull
  private LocalCategory category;

  @Getter
  @Setter
  @OneToMany
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  private List<Photo> photos;

  @Getter
  @Setter
  @OneToOne
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  @NotNull
  private Address address;

  @Getter
  @Setter
  @OneToMany
  private List<Comment> comments;

  @Getter
  @Setter
  @OneToMany
  private List<Evaluation> evaluations;
}
