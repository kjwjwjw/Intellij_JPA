package com.example.boot2.service;

import com.example.boot2.entity.Study_record;
import com.example.boot2.repository.StudyRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyRecordService {

    @Autowired
    StudyRecordRepo studyRecordRepo;

    public List<Study_record> doSelectAll() {
        return studyRecordRepo.findAll();
    }

    /* One row Select */
    public Study_record doSelectOne(int key_id) {
        return studyRecordRepo.findById(key_id).get();
    }


    /* Insert */
    public void doInsert(Study_record study_record) {
        studyRecordRepo.save(study_record);
    }

    /* Update */
    public void doUpdate(Study_record study_record) {
        studyRecordRepo.save(study_record);
    }

    /* Delete */
    public void doDelete(int key_id) {
        studyRecordRepo.deleteById(key_id);
    }


}
