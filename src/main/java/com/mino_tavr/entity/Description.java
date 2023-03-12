package com.mino_tavr.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "description")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "device")
    private String device;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "inventory_number")
    private String inventoryNumber;
    @Column(name = "remark")
    private String remark;
}
