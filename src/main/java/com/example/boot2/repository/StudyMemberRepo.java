package com.example.boot2.repository;

import com.example.boot2.entity.Study_member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyMemberRepo extends JpaRepository<Study_member, Integer> {


    Study_member findByLoginId(String loginId);


}
