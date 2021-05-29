package com.tourism.tourism.evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    @Query(value = "select " +
            "           e.* " +
            "       from " +
            "           ingamaps.local_evaluations le " +
            "       inner join ingamaps.evaluation e on " +
            "           e.id = le.evaluations_id " +
            "       where " +
            "           e.tourist_id = :touristId " +
            "           and le.local_id = :localId",
            nativeQuery = true)
    List<Evaluation> getEvaluationByLocalAndTourist(@Param("localId") Long localId,
                                                    @Param("touristId") Long touristId);
}
