package com.example.boot2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Study_record {
    @Id
    private int key_id ;

    private String STUDY_DAY ;

    private String CONTENTS ;

    private LocalDateTime reg_day;

}
