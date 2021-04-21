package com.tourism.tourism.evaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EvaluationService {
  @Autowired
  private EvaluationRepository evaluationRepository;
}
