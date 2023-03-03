package com.mino_tavr.dto;

import com.mino_tavr.entity.Dealer;
import com.mino_tavr.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.awt.image.BufferedImage;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllCardNumberResponseDto {

    Integer id_card_number;
    String number;
    BufferedImage image;
    int device_type;

    Integer interaction_id;
    String interaction_date_start;
    String interaction_date_end;

    Integer dealer_start_id;
    String dealer_start_name;
    String dealer_start_surname;
    String dealer_start_patronymic;
    String dealer_start_subdivision;
    String dealer_start_department;

    Integer dealer_end_id;
    String dealer_end_name;
    String dealer_end_surname;
    String dealer_end_patronymic;
    String dealer_end_subdivision;
    String dealer_end_department;

    Integer member_start_id;
    String member_start_name;
    String member_start_surname;
    String member_start_patronymic;

    Integer member_end_id;
    String member_end_name;
    String member_end_surname;
    String member_end_patronymic;

    Integer reason_id;
    int reason_type;
    String reason_number;

    Integer description_id;
    String description_name;
    String serial_number;
    String inventory_number;
    String remark;

}
