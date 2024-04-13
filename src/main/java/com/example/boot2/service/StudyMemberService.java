package com.example.boot2.service;


import com.example.boot2.comm.Cm_encrypt;
import com.example.boot2.entity.Study_member;
import com.example.boot2.repository.StudyMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyMemberService {

    @Autowired
    StudyMemberRepo studyMemberRepo;

    @Value("${encrypt.key16}")
    private String strKey16;


    public List<Study_member> doSelectAll() throws Exception {
        Cm_encrypt cm_encrypt = new Cm_encrypt();


        List<Study_member> list = studyMemberRepo.findAll();

        for(Study_member study_member : list) {
            study_member.setEmail(cm_encrypt.decryptAes(study_member.getEmail(), strKey16));
        }

        return list;
    }

    /* One row Select */
    public Study_member doSelectOne(int memberId) {
        return studyMemberRepo.findById(memberId).get();
    }


    public Study_member doSelectLoginId(String strLoginId) {
        return studyMemberRepo.findByLoginId(strLoginId);
    }


    /* Insert */
    public void doInsert(Study_member study_member) throws Exception {
        Cm_encrypt cm_encrypt = new Cm_encrypt();

        study_member.setPassword(cm_encrypt.encryptSha256(study_member.getPassword()));

        study_member.setEmail(cm_encrypt.encryptAes(study_member.getEmail(), strKey16));

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
