package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "Pozisyonlar")
    public class Pozisyon {

        @Id
        @Column(name = "pozisyon_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int pozisyonId;

        @Column(name = "pozisyon_name", nullable = false)
        private String pozisyonName;


    }
