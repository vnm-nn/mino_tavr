package com.mino_tavr.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PreviewModelsResponseDto {
    private Integer id;
    private byte[] image;
}
