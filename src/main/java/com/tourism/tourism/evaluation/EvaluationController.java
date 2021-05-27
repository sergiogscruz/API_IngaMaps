package com.tourism.tourism.evaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {
  @Autowired
  private EvaluationService evaluationService;

  @PostMapping
  public Evaluation evaluateLocal(@RequestParam Long localId,
                                  @RequestParam Integer note) {
    return evaluationService.evaluateLocal(localId, note);
  }
}
