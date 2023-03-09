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
    private String memberName;
    private Date date;
    private Date notification;
    private List<DescriptionDto> descriptions;
}
