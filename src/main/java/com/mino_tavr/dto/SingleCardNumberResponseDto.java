package com.mino_tavr.dto;

import com.mino_tavr.entity.Interaction;
import com.mino_tavr.entity.Reason;
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
    Reason reason;
    List<DescriptionResponseDto> description;

}
