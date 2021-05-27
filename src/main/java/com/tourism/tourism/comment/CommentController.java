package com.tourism.tourism.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
  @Autowired
  private CommentService commentService;

  @PostMapping
  public Comment commentLocal(@RequestParam Long localId,
                           @RequestBody String comment) {
    return commentService.commentLocal(localId, comment);
  }
}
