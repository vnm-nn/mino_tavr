package com.mino_tavr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescriptionResponseDto {

    Integer id_description;
    String description_name;
    String serial_number;
    String inventory_number;
    String remark;

}
