package com.tourism.tourism.contact;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query(nativeQuery = true, value = "select " +
            "                               c.* " +
            "                           from " +
            "                               ingamaps.contact c " +
            "                           where " +
            "                               c.name ilike concat('%',:name,'%') " +
            "                               and c.category ilike concat('%',:category,'%')")
    Page<Contact> getContactsByNameAndCategory(Pageable pageable, @Param("name") String name, @Param("category") String category);
}
