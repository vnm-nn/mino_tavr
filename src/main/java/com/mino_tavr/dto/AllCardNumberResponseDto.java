package com.mino_tavr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.image.BufferedImage;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllCardNumberResponseDto {

    Integer id_card_number;
    String number;
    BufferedImage image;
    String device_type;
    int interaction_id;
    int reason_id;
    int descriptionQuantity;

}
