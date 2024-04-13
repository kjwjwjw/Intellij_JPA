package com.example.boot2.config.secure;

import com.example.boot2.entity.Study_member;
import com.example.boot2.service.StudyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecureUser implements UserDetailsService {

    @Autowired
    StudyMemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("=== SecureUser >> loadUserByUsername ====== ");

        Study_member vo_member = memberService.doSelectLoginId(username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(vo_member.getRole()));

        return new User(vo_member.getLoginId(), "{noop}"+vo_member.getPassword(), authorities);
    }
}
