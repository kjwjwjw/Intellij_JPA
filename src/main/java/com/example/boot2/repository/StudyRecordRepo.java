package com.example.boot2.repository;

import com.example.boot2.entity.Study_record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyRecordRepo extends JpaRepository<Study_record, Integer> {

   /* @Query(value = "SELECT a. * , b. * " +
            "FROM study_record a, study_member b " +
            "WHERE a.member_id = b.member_id ", nativeQuery = true)

    List<Study_record> findJpql();*/
}
