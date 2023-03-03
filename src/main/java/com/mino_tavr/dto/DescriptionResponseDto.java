package com.mino_tavr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescriptionResponseDto {
    private Integer id_description;
    private String description_name;
    private String serial_number;
    private String inventory_number;
    private String remark;

}
