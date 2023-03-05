package com.mino_tavr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DescriptionDto {
    private String name;
    private String serialNumber;
    private String inventoryNumber;
    private String remark;
}
