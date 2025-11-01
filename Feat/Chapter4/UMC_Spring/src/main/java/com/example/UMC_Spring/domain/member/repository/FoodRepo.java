package com.example.UMC_Spring.domain.member.repository;

import com.example.UMC_Spring.domain.member.entity.Food;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query("SELECT f FROM Food f")
    List<Food> findAllFoods();

    @Query("SELECT f FROM Food f WHERE f.name = :name")
    Food findByName(@Param("name") String name);

    @Query("SELECT f.name FROM Food f")
    List<String> findAllFoodNames();
}

