package com.mino_tavr.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "interaction")
@Getter
@Setter
@NoArgsConstructor
public class Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id_interaction;

    @Column(name = "interaction_date_start")
    String interaction_date_start;

    @Column(name = "interaction_date_end")
    String interaction_date_end;

    @Column(name = "id_dealer_start")
    Dealer dealer_start;

    @Column(name = "id_dealer_end")
    Dealer dealer_end;

    @Column(name = "id_member_start")
    Dealer member_start;

    @Column(name = "id_member_start")
    Dealer member_end;


}
