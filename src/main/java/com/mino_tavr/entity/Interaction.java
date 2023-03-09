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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private Date date;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "dealer_id")
    private Employee dealer;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Employee member;
}