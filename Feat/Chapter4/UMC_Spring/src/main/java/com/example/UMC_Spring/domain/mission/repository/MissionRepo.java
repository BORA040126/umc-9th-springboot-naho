package com.example.UMC_Spring.domain.mission.repository;

import com.example.UMC_Spring.domain.mission.entity.Mission;
import com.example.UMC_Spring.domain.store.entity.Store;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MissionRepo extends JpaRepository<Mission, Long> {

    @Query(value = "SELECT m FROM Mission m WHERE m.store IN :stores AND m.deadline >= CURRENT_DATE",
            countQuery = "SELECT COUNT(m) FROM Mission m WHERE m.store IN :stores AND m.deadline >= CURRENT_DATE")
    Page<Mission> findActiveByStores(@Param("stores") List<Store> stores, Pageable pageable);

    @Query(value = "SELECT m FROM Mission m WHERE m.store IN :stores AND m.deadline >= CURRENT_DATE AND m.MissionId NOT IN :excludeIds",
            countQuery = "SELECT COUNT(m) FROM Mission m WHERE m.store IN :stores AND m.deadline >= CURRENT_DATE AND m.MissionId NOT IN :excludeIds")
    Page<Mission> findActiveByStoresExcluding(@Param("stores") List<Store> stores,
                                              @Param("excludeIds") List<Long> excludeIds,
                                              Pageable pageable);

    @Query("SELECT m FROM Mission m WHERE m.store = :store AND m.deadline >= CURRENT_DATE")
    Page<Mission> findActiveByStore(@Param("store") Store store, Pageable pageable);
}
