package com.mino_tavr.entity;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "dealer")
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dealer")
    private int id_dealer;

    @Column(name = "dealer_name")
    private String dealer_name;

    @Column(name = "member_surname")
    private String dealer_surname;

    @Column(name = "member_patronymic")
    private String dealer_patronymic;

    @Column(name = "subdivision")
    private String subdivision;

    @Column(name = "department")
    private String department;

}
