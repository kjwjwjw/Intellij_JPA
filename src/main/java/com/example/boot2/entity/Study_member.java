package com.example.boot2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Study_member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "member_id")
    private int memberId;

    @Column(name ="login_id")
    private String loginId ;

    private String password ;

    private String name ;

    private String email;

    private String role ;

    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name="member_regday", updatable = false)
    private LocalDateTime member_regday;


}
