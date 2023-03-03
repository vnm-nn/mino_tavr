package com.mino_tavr.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reason")
@Getter
@Setter
@NoArgsConstructor
public class Reason {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id_reason;

    @Column(name = "reason_type")
    int reason_type;

    @Column(name = "reason_number")
    String reason_number;

}
