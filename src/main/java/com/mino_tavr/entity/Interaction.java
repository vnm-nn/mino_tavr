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
    private Date makingStartDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "making_date_end")
    private Date makingEndDate;
    @OneToOne
    @JoinColumn(name = "dealer_passed_id")
    private Employee dealerPassed;
    @OneToOne
    @JoinColumn(name = "member_accepted_id")
    private Employee memberAccepted;
    @OneToOne
    @JoinColumn(name = "member_passed_id")
    private Employee memberPassed;
    @OneToOne
    @JoinColumn(name = "dealer_accepted_id")
    private Employee dealerAccepted;
}