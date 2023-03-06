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
    private InteractionDto interactionBegin;
    private InteractionDto interactionEnd;
    private List<DescriptionDto> descriptions;
}
