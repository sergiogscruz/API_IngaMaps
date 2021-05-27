package com.tourism.tourism.comment;

import com.tourism.tourism.local.LocalService;
import com.tourism.tourism.tourist.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentService {
  @Autowired
  private CommentRepository commentRepository;
  @Autowired
  private LocalService localService;
  @Autowired
  private TouristService touristService;

  public Comment commentLocal(Long localId, String commentString) {
    Comment comment = new Comment();
    comment.setComment(commentString);
    comment.setLocal(localService.getAndValidateById(localId));
    comment.setTourist(touristService.getCurrentTourist());
    return commentRepository.save(comment);
  }
}
