package com.mino_tavr.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] img;
    @Column(name = "device_type")
    private int deviceType;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interaction_begin_id")
    private Interaction interactionBegin;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interaction_end_id")
    private Interaction interactionEnd;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reason_id")
    private Reason reason;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "description_id")
    private List<Description> descriptions;
}
