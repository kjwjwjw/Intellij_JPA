package com.example.boot2.service;


import com.example.boot2.entity.Study_member;
import com.example.boot2.entity.Study_record;
import com.example.boot2.repository.StudyMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyMemberService {

    @Autowired
    StudyMemberRepo studyMemberRepo;


    public List<Study_member> doSelectAll() {
        return studyMemberRepo.findAll();
    }

    /* One row Select */
    public Study_member doSelectOne(int memberId) {
        return studyMemberRepo.findById(memberId).get();
    }


    /* Insert */
    public void doInsert(Study_member study_member) {
        studyMemberRepo.save(study_member);
    }

    /* Update */
    public void doUpdate(Study_member study_member) {
        studyMemberRepo.save(study_member);
    }

    /* Delete */
    public void doDelete(int memberId) {
        studyMemberRepo.deleteById(memberId);
    }
}
