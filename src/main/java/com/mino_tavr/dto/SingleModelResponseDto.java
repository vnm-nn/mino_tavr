package com.mino_tavr.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class SingleModelResponseDto {
    private Integer id;
    private byte[] img;
    private int deviceType;
    private int reason;
    private String reasonNumber;
    private Date makingStartDate;
    private Date makingEndDate;
    private EmployeeDto dealerPassed;
    private EmployeeDto memberAccept;
    private EmployeeDto memberPassed;
    private EmployeeDto dealerAccept;
    private List<DescriptionDto> descriptions;
}
