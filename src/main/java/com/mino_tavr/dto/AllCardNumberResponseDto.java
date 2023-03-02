package com.mino_tavr.dto;

import com.mino_tavr.entity.Dealer;
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
    String interaction_date_start;
    String interaction_date_end;
    Dealer dealer_start;
    Dealer dealer_end;
    Dealer member_start;
    Dealer member_end;

    int reason_id;
    String reason_type;
    String reason_number;

    int description_id;
    String description_name;
    String serial_number;
    String inventory_number;
    String remark;

}
