package com.tourism.tourism.evaluation;

import com.tourism.tourism.evaluation.dtos.EvaluateLocalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {
  @Autowired
  private EvaluationService evaluationService;

  @PostMapping
  public void evaluateLocal(@RequestBody EvaluateLocalDto evaluateLocalDto) {
    evaluationService.evaluateLocal(evaluateLocalDto);
  }
}
