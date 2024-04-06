package com.example.boot2.repository;

import com.example.boot2.entity.Study_record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRecordRepo extends JpaRepository<Study_record, Integer> {


}
