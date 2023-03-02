package com.mino_tavr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.image.BufferedImage;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPreviousCard {

    Integer id_card_number;
    String number;
    BufferedImage image;

}
