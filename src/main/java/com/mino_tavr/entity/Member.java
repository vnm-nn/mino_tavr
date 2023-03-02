package com.mino_tavr.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id_member;

    @Column(name = "member_name")
    String member_name;

    @Column(name = "member_surname")
    String member_surname;

    @Column(name = "member_patronymic")
    String member_patronymic;



}
