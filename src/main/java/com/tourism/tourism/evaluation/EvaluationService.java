package com.tourism.tourism.evaluation;

import com.tourism.tourism.evaluation.dtos.EvaluateLocalDto;
import com.tourism.tourism.evaluation.exceptions.EvaluationBadRequestException;
import com.tourism.tourism.local.Local;
import com.tourism.tourism.local.LocalService;
import com.tourism.tourism.tourist.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EvaluationService {
  @Autowired
  private EvaluationRepository evaluationRepository;
  @Autowired
  private LocalService localService;
  @Autowired
  private TouristService touristService;

  public void evaluateLocal(EvaluateLocalDto evaluateLocalDto) {
    checkLocalAlreadyEvaluate(evaluateLocalDto.getLocalId(), touristService.getCurrentTourist().getId());
    Local local = localService.getAndValidateById(evaluateLocalDto.getLocalId());
    validateNote(evaluateLocalDto.getNote());
    Evaluation evaluation = new Evaluation();
    evaluation.setNote(evaluateLocalDto.getNote());
    evaluation.setTourist(touristService.getCurrentTourist());
    local.getEvaluations().add(evaluationRepository.save(evaluation));
    localService.save(local);
  }


  public void checkLocalAlreadyEvaluate(Long localId, Long touristId) {
    List<Evaluation> evaluations = evaluationRepository.getEvaluationByLocalAndTourist(localId, touristId);
    if (evaluations.size() > 0) {
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
