package com.mino_tavr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class InteractionDto {
    private Date date;
    private EmployeeDto dealer;
    private EmployeeDto member;
}
