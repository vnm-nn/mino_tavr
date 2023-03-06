package com.mino_tavr.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "interaction")
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "making_date_start")
    private Date date;
    @OneToOne
    @JoinColumn(name = "dealer_id")
    private Employee dealer;
    @OneToOne
    @JoinColumn(name = "member_id")
    private Employee member;
}