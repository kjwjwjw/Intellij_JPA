package com.example.boot2.controller;


import com.example.boot2.entity.Study_member;
import com.example.boot2.repository.StudyMemberRepo;
import com.example.boot2.service.StudyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member")
public class Con_member {

    @Autowired
    StudyMemberService studyMemberService;

    @GetMapping("/list")
    public String doMemberList(Model model) throws Exception {

        List<Study_member> list = studyMemberService.doSelectAll();

        model.addAttribute("list", list);


        return "/member/member_list";

    }

    @GetMapping("/insert")
    public String doIns() { return "/member/member_join";}


    @PostMapping("/insert_exe")
    public String doInsExe(@ModelAttribute Study_member study_member) {

       studyMemberService.doInsert(study_member);

       return "redirect:/member/list";
    }

    @GetMapping("/delete")
    public String doDel(@RequestParam(value = "memberId", defaultValue = "--") String strMemberId) {

        studyMemberService.doDelete(Integer.parseInt(strMemberId));

        return "redirect:/member/list";
    }
}
