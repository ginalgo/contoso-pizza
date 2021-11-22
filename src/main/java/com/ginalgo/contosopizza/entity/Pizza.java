package com.ginalgo.contosopizza.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Boolean isGlutenFree;
}
