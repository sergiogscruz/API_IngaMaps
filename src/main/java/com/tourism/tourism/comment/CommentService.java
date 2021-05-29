package com.tourism.tourism.comment;

import com.tourism.tourism.comment.dtos.CommentLocalDto;
import com.tourism.tourism.local.Local;
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

  public void commentLocal(CommentLocalDto commentLocalDto) {
    Local local = localService.getAndValidateById(commentLocalDto.getLocalId());
    Comment comment = new Comment();
    comment.setComment(commentLocalDto.getCommentString());
    comment.setTourist(touristService.getCurrentTourist());
    local.getComments().add(commentRepository.save(comment));
    localService.save(local);
  }
}
