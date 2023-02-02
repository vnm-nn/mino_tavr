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
    private int Id_dealer;

    @Column(name = "dealer_name")
    private String Dealer_name;

    @Column(name = "subdivision")
    private String Subdivision;

    @Column(name = "department")
    private String Department;
}
