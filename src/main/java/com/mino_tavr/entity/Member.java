package com.mino_tavr.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_member")
    private int Id_Member;

    @Column(name = "name_member")
    private int Name_member;

    @Column(name = "pas_member")
    private int Pas_member;
}
