package com.mino_tavr.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "description")
@Getter
@Setter
@NoArgsConstructor
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_description")
    int id_description;

    @Column(name = "description_name")
    String description_name;

    @Column(name = "serial_number")
    String serial_number;

    @Column(name = "inventory_number")
    String inventory_number;

    @Column(name = "remark")
    String remark;

}
