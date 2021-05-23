package com.tourism.tourism.tourist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
    Tourist getByUserLoginId(String userLogin);
}
