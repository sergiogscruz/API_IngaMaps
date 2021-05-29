package com.tourism.tourism.comment;

import com.tourism.tourism.comment.dtos.CommentLocalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
  @Autowired
  private CommentService commentService;

  @PostMapping
  public void commentLocal(@RequestBody CommentLocalDto commentLocalDto) {
    commentService.commentLocal(commentLocalDto);
  }
}
