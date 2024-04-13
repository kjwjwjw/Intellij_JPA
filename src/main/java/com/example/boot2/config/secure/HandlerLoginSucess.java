package com.example.boot2.config.secure;

import com.example.boot2.entity.Study_member;
import com.example.boot2.service.StudyMemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Component
public class HandlerLoginSucess implements AuthenticationSuccessHandler {

    @Autowired
    StudyMemberService memberService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("===== onAuthenticationSuccess ==== ");

        Study_member vo_member = memberService.doSelectLoginId(authentication.getName());

        // 세션추가
        HttpSession session = request.getSession();
            session.setAttribute("ss_member_id", vo_member.getMemberId());
            session.setAttribute("ss_login_id", vo_member.getLoginId());
            session.setAttribute("ss_name", vo_member.getName());
            session.setAttribute("ss_role", vo_member.getRole());
        
        // url 이동 위치
        String strUrl ="/"; // 성공 이후 가야할 위치

        // Security 가 요청을 가로챈 경우 사용자가 원래 요청했던 URI 정보를 저장한 객체
        RequestCache requestCache = new HttpSessionRequestCache();
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        // 있을 경우 URI 등 정보를 가져와서 사용
        if (savedRequest != null) {
            strUrl = savedRequest.getRedirectUrl();
            // 세션에 저장된 객체를 다 사용한 뒤에는 지워줘서 메모리 누수 방지
            requestCache.removeRequest(request, response);
        }

        response.sendRedirect(strUrl);
    }
}
