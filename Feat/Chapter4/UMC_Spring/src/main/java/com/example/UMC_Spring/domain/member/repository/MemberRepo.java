package com.example.UMC_Spring.domain.member.repository;

import com.example.UMC_Spring.domain.member.entity.Member;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepo extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);


    @Query("SELECT m FROM Member m WHERE m.memberName = :name")
    Member findOneByName(@Param("name") String name);
}