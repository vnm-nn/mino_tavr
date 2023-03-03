package com.mino_tavr.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.util.List;

@Entity
@Table(name = "card_number")
@Getter
@Setter
@NoArgsConstructor
public class CardNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id_card_number;

    @Column(name = "number")
    String number;

    @Column(name = "image", columnDefinition = "BLOB")
    @Lob
    private byte[] image;

    @Column(name = "device_type")
    int device_type;

    @Column(name = "interaction")
    Interaction interaction;

    @Column(name = "reason")
    Reason reason;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "description")
    List<Description> description;

}
