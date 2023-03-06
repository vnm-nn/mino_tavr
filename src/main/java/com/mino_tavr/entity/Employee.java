package com.mino_tavr.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "name")
    private String name;
    @NonNull
    @Column(name = "subdivision")
    private String subdivision;
    @NonNull
    @Column(name = "department")
    private String department;
}
