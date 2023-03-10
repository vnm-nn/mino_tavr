package com.mino_tavr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class AddModelRequestDto {
    private int deviceType;
    private int reason;
    private String reasonNumber;
    private EmployeeDto dealer;
    private Date date;
    private Date notification;
    private String memberName;
    private List<DescriptionDto> descriptions;
}
