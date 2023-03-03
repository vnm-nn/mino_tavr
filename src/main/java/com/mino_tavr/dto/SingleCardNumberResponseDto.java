package com.mino_tavr.dto;

import com.mino_tavr.entity.Interaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.image.BufferedImage;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleCardNumberResponseDto {

    Integer id_card_number;
    String number;
    byte[]  image;
    int device_type;
    Interaction interaction;
    int reason_id;
    List<DescriptionResponseDto> description;

}
