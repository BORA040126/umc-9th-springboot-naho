package com.example.UMC_Spring.domain.store.repository;

import com.example.UMC_Spring.domain.store.entity.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface StoreRepo extends JpaRepository<Store, Long> {

    @Query("SELECT s FROM Store s WHERE s.location = :location")
    List<Store> findByLocation(@Param("location") Location location);

    @Query(value = "SELECT s FROM Store s WHERE s.location = :location",
            countQuery = "SELECT COUNT(s) FROM Store s WHERE s.location = :location")
    Page<Store> findByLocation(@Param("location") Location location, Pageable pageable);

    @Query("SELECT s FROM Store s WHERE s.name LIKE %:keyword%")
    Page<Store> searchByName(@Param("keyword") String keyword, Pageable pageable);
}


