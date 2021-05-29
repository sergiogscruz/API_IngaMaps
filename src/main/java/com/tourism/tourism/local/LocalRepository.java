package com.tourism.tourism.local;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalRepository extends JpaRepository<Local, Long> {

    Page<Local> findByNameLike(Pageable page, String name);

    Page<Local> findByNameLikeAndCategory(Pageable page, String name, LocalCategory category);
    
}
