package com.tourism.tourism.evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    @Query("select e from Evaluation e where e.local.id = :localId and e.tourist.id = :touristId")
    Optional<Evaluation> getEvaluationByLocalAndTourist(@Param("localId") Long localId,
                                                        @Param("touristId") Long touristId);
}
