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
    int id_dealer;

    @Column(name = "dealer_name")
    String dealer_name;

    @Column(name = "subdivision")
    String subdivision;

    @Column(name = "department")
    String department;

}
