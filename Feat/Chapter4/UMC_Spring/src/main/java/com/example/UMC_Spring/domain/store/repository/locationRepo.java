package com.example.UMC_Spring.domain.store.repository;

import com.example.UMC_Spring.domain.store.entity.Location;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("SELECT l FROM Location l WHERE l.name = :name")
    Location findByName(@Param("name") String name);
}
