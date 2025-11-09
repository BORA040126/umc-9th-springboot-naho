package com.example.UMC_Spring.domain.member.repository;

import com.example.UMC_Spring.domain.member.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MemberFoodRepo extends JpaRepository<MemberFood, Long> {

    @Query("SELECT mf FROM MemberFood mf WHERE mf.memberId = :member")
    List<MemberFood> findByMember(@Param("member") Member member);

    @Query("SELECT mf FROM MemberFood mf WHERE mf.foodId = :food")
    List<MemberFood> findByFood(@Param("food") Food food);

    @Query("SELECT COUNT(mf) FROM MemberFood mf WHERE mf.memberId = :member")
    long countByMember(@Param("member") Member member);

    @Query("SELECT mf.foodId FROM MemberFood mf WHERE mf.memberId = :member")
    List<Food> findFoodsByMember(@Param("member") Member member);

    @Query("SELECT mf.memberId FROM MemberFood mf WHERE mf.foodId = :food")
    List<Member> findMembersByFood(@Param("food") Food food);
}

