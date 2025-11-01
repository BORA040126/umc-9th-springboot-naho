package com.example.UMC_Spring.domain.member.repository;

import com.example.UMC_Spring.domain.member.entity.Member;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE m.memberEmail = :email")
    Member findByEmail(@Param("email") String email);

    @Query("SELECT m FROM Member m WHERE m.memberName = :name")
    Member findOneByName(@Param("name") String name);
}

