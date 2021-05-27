package com.tourism.tourism.evaluation;

import com.tourism.tourism.local.LocalService;
import com.tourism.tourism.tourist.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EvaluationService {
  @Autowired
  private EvaluationRepository evaluationRepository;
  @Autowired
  private LocalService localService;
  @Autowired
  private TouristService touristService;

  public Evaluation evaluateLocal(Long localId, Integer note) {
    checkLocalAlreadyEvaluate(localId, touristService.getCurrentTourist().getId());
    validateNote(note);
    Evaluation evaluation = new Evaluation();
    evaluation.setNote(note);
    evaluation.setLocal(localService.getAndValidateById(localId));
    evaluation.setTourist(touristService.getCurrentTourist());
    return evaluationRepository.save(evaluation);
  }

  public void checkLocalAlreadyEvaluate(Long localId, Long touristId) {
    Optional<Evaluation> evaluation = evaluationRepository.getEvaluationByLocalAndTourist(localId, touristId);
    if (evaluation.isPresent()) {
      throw new EvaluationBadRequestException("Local already evaluate.");
    }
  }

  public void validateNote(Integer note) {
    if (note < 1) {
      throw new EvaluationBadRequestException("Note less than one.");
    } else if (note > 5) {
      throw new EvaluationBadRequestException("Note higher than five.");
    }
  }
}
